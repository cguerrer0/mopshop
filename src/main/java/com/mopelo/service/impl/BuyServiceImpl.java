/**
 * 
 */
package com.mopelo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.Center;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.CssStyle;
import com.googlecode.wickedcharts.highcharts.options.DataLabels;
import com.googlecode.wickedcharts.highcharts.options.Labels;
import com.googlecode.wickedcharts.highcharts.options.Marker;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.PixelOrPercent;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.Point;
import com.googlecode.wickedcharts.highcharts.options.series.PointSeries;
import com.googlecode.wickedcharts.highcharts.options.series.Series;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.OrderDao;
import com.mopelo.dao.ProductDao;
import com.mopelo.domain.Customer;
import com.mopelo.domain.Order;
import com.mopelo.domain.OrderRow;
import com.mopelo.domain.OrderStatus;
import com.mopelo.domain.Product;
import com.mopelo.service.BuyService;
import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.OrderDTO;
import com.mopelo.service.dto.OrderRowDTO;
import com.mopelo.service.dto.ProductDTO;
import com.mopelo.util.Entry;
import com.mopelo.util.LoggerUtils;
import com.mopelo.util.MapperUtils;

/**
 * Implementation of {@link BuyService}
 * 
 * @author cguerrero
 */
@Service(BuyService.BEAN_NAME)
public class BuyServiceImpl implements BuyService {

	/**
	 * {@link CustomerDao}
	 */
	@Autowired
	private CustomerDao customerDao;
	/**
	 * {@link productDao}
	 */
	@Autowired
	private ProductDao productDao;

	/**
	 * {@link orderDao}
	 */
	@Autowired
	private OrderDao orderDao;
	private List<BuyProductDTO> shoppingCart;
	private CustomerDTO customer;
	private boolean confirm;


	@Override
	public void initShoppingCart() {
		this.shoppingCart = new Vector<BuyProductDTO>();
		this.customer = null;
		this.confirm = false;
	}

	@Override
	public void addProduct(long idProduct, long number) {
		if (shoppingCart == null) {
			initShoppingCart();
		}

		if (!confirm) {
			Product prod = productDao.getById(idProduct);
			if (prod != null) {
				ProductDTO pDTO = MapperUtils.map(prod, ProductDTO.class);
				BuyProductDTO findItem = lookForItem(pDTO.getId());
				if (findItem != null) {
					findItem.increaseNumber(1);
				} else {
					shoppingCart.add(new BuyProductDTO(pDTO, 1));
				}

			}

		}

	}

	private BuyProductDTO lookForItem(Long idProd) {
		BuyProductDTO item = null;
		if (shoppingCart != null) {
			for (BuyProductDTO buyProduct : shoppingCart) {
				ProductDTO product = buyProduct.getProduct();
				if (product != null && product.getId().equals(idProd)) {
					item = new BuyProductDTO();
					item = buyProduct;
					break;
				}
			}
		}

		return item;
	}

	@Override
	public void modifyNumber(long idProduct, long number, String operation) {

		BuyProductDTO findItem = lookForItem(idProduct);
		if (findItem != null) {
			if (operation.equals("INCREASE")) {
				findItem.increaseNumber(number);
			} else if (operation.equals("UPDATE")) {
				findItem.setNumber(number);
			} else {
				findItem.decreaseNumber(number);
			}
		}

	}

	@Override
	public void clearCart() {
		if (shoppingCart == null) {
			initShoppingCart();
		} else {
			shoppingCart.clear();
			confirm = false;
		}
	}

	@Override
	public void deleteProduct(long idProduct) {
		if (!confirm && shoppingCart != null) {
			int index = 0;
			for (BuyProductDTO buyProductDTO : shoppingCart) {
				ProductDTO productDTO = buyProductDTO.getProduct();
				if (productDTO != null && productDTO.getId() == idProduct) {
					shoppingCart.remove(index);
					break;
				}
			}

		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = false)
	public OrderDTO createOrder(CustomerDTO customerDTO) {
		OrderDTO orderDTO = null;
		List<OrderRow> orderRows = new Vector<OrderRow>();
		customer = customerDTO;
		if (confirm && customer != null) {
			Order orderEntity = null;
			Customer customerEntity = MapperUtils.map(customer, Customer.class);
			orderEntity = new Order(customerEntity, Calendar.getInstance()
					.getTime(), OrderStatus.CONFIRMED);

			for (BuyProductDTO item : shoppingCart) {
				LoggerUtils.logDebug(item.toString());
				ProductDTO productBP = item.getProduct();
				if (productBP != null && productBP.getId() != null) {
					Product productEntity = MapperUtils.map(productBP,
							Product.class);
					OrderRow orderRowEntity = new OrderRow(orderEntity,
							productEntity, item.getNumber(),
							productBP.getPrice(), 0.0);
					LoggerUtils.logDebug(productBP.toString());
					orderRows.add(orderRowEntity);

				}
			}
			orderEntity.setOrderRows(orderRows);
			Long id = orderDao.insert(orderEntity);
			if (id != null && orderRows != null) {
				orderDao.insertOrderRow(orderRows);
			}
			orderDTO = MapperUtils.map(orderEntity, OrderDTO.class);
			orderDTO.setLineRows(MapperUtils.mapAsList(orderRows,
					OrderRowDTO.class));
			clearCart();
		}

		return orderDTO;
	}

	@Override
	public List<BuyProductDTO> getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public double calculateTotalAmount() {
		double total = 0.0;
		if (shoppingCart != null && !shoppingCart.isEmpty()) {
			for (BuyProductDTO cart : shoppingCart) {
				ProductDTO product = cart.getProduct();
				double partial = 0.0;
				if (product != null) {
					partial = cart.getNumber() * product.getPrice();
				}
				total += partial;
			}

		}
		
		 total =new BigDecimal(total).setScale(2, BigDecimal.ROUND_UP).doubleValue();
	   
		return total;
	}

	@Override
	public void confirmShoppingCart() {
		if (checkExistences()) {// check existences
			this.confirm = true;

		}

	}

	private boolean checkExistences() {
		boolean result = true;
		// TODO implement method checkExistences
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public Options createComboOption() {

		Options comboOption = new Options();

		ChartOptions chartOptions = new ChartOptions();
		comboOption.setChartOptions(chartOptions);
		comboOption.setTitle(new Title("Total Sales"));
		comboOption.setTooltip(new Tooltip());

		comboOption.setLabels(new Labels().setStyle(new CssStyle()));
		Axis xAxis = new Axis();
		Marker series4Marker = new Marker();
		series4Marker.setLineWidth(2);
		series4Marker.setLineColor(new HexColor("#990000"));
		series4Marker.setFillColor(new HexColor("#ffffff"));

		List<String> listBrand = new ArrayList<String>();
		List<String> lCategories = new ArrayList<String>();
		listBrand = orderDao.getBrandWithOrder();
		List<Entry> listCategories = new ArrayList<Entry>();
		listCategories = orderDao.getFamiliesWithOrder();
		List<Number> listTotalByFamily = new ArrayList<Number>();
		List<Number> listTotalByBrand = new ArrayList<Number>();
		Series<Number> series4 = new SimpleSeries();
		series4.setType(SeriesType.SPLINE);
		series4.setName("Total sales by family");
		
		  PointSeries series5 = new PointSeries();
		    series5
		        .setType(SeriesType.PIE);
		    series5
	        .setName("Total sales by brand");
		    
		 for(Entry cat :listCategories){
			 listTotalByBrand.add(cat.getValue());
			 lCategories.add(cat.getKey());
			 
		 }
		    
		    
		for (String brand : listBrand) {
			Map<String, Integer> mapBrandNumberByFamily = convertToMap(orderDao
					.getNumberProductByBrandAndFamily(brand));
			long totalByFamily = 0;
			Series<Number> series = new SimpleSeries();
			series.setType(SeriesType.COLUMN);
			series.setName(brand);
			List<Number> listData = new ArrayList<Number>();
			for (String categorie : lCategories) {
				int num = 0;
				if (mapBrandNumberByFamily.containsKey(categorie)) {
					num = mapBrandNumberByFamily.get(categorie);
				}
				listData.add(num);
				totalByFamily = totalByFamily + num;

			}
			 series5
		        .addPoint(new Point(brand, totalByFamily));
			listTotalByFamily.add(totalByFamily);
			series.setData(listData);
			comboOption.addSeries(series);
		}
		xAxis.setCategories(lCategories);
		comboOption.setxAxis(xAxis);
		series4.setData(listTotalByBrand);
		series4.setMarker(series4Marker);
		comboOption.addSeries(series4);
	    series5
	        .setCenter(new Center(100, 80, Center.Unit.PIXELS));
	    series5
	        .setSize(new PixelOrPercent(100, PixelOrPercent.Unit.PIXELS));
	    series5
	        .setShowInLegend(Boolean.FALSE);
	    series5
	        .setDataLabels(new DataLabels(Boolean.TRUE));
	    comboOption.addSeries(series5);

		return comboOption;

	}

	private Map<String, Integer> convertToMap(
			List<Entry> numberProductByBrandAndFamily) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Entry e : numberProductByBrandAndFamily) {
			map.put(e.getKey(), e.getValue());
		}
		return map;
	}
	

}
