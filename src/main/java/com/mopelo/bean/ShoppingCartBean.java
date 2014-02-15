package com.mopelo.bean;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.mopelo.service.BuyService;
import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.OrderDTO;

@ManagedBean
public class ShoppingCartBean {

	BuyProductDTO currentBuyProduct = null;
	OrderDTO order = null;
	double totalAmount;
	List<BuyProductDTO> products;
	
	
	@ManagedProperty(value = "#{userBean}")
	UserBean userBean;
	
    /**
	 * {@link BuyService}
	 */
	@ManagedProperty(value = BuyService.EL_NAME)
	private BuyService buyService;
	
	
	public String doAddProduct (long id){
		String surf = null;
	    //we have to stay in the same page.
		
		return surf;
	}
	public String doDeleteProduct (long id){
		String surf = null;
	    //we have to stay in the same page.
		
		return surf;
	}
	public String doConfirmCart (long id){
		String surf = null;
	    //we have to stay in the same page.
		
		return surf;
	}
	public String doClearCart (long id){
		String surf = null;
	    //we have to stay in the same page.
		
		return surf;
	}
	public String doIncNumber (long id){
		String surf = null;
	    //we have to stay in the same page.
		
		return surf;
	}
	
	
	
	
	
	
	

	/**
	 * @return the products
	 */
	public List<BuyProductDTO> getProducts() {
		return (List<BuyProductDTO>) buyService.getShoppingCart();
	}

	/**
	 * @return the currentBuyProduct
	 */
	public BuyProductDTO getCurrentBuyProduct() {
		return currentBuyProduct;
	}

	/**
	 * @param currentBuyProduct the currentBuyProduct to set
	 */
	public void setCurrentBuyProduct(BuyProductDTO currentBuyProduct) {
		this.currentBuyProduct = currentBuyProduct;
	}

	/**
	 * @return the order
	 */
	public OrderDTO getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


	/**
	 * @param buyService the buyService to set
	 */
	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}
	
	
	
	
	
	
	

}
