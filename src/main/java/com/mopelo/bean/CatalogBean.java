package com.mopelo.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.theme.Theme;
import com.mopelo.common.bean.GenericBean;
import com.mopelo.service.BuyService;
import com.mopelo.service.CatalogService;
import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.ProductDTO;

@ManagedBean
@SessionScoped	
public class CatalogBean extends GenericBean {

	private FamilyDTO currentFamily;
	private ProductDTO currentProduct;
	private List<FamilyDTO> families;
	private List<ProductDTO> products;
	private String checkDescription;
	private String checkBrand;
	private Theme myTheme;
	private Options options;


	@PostConstruct
	public void init() {
		currentFamily = null;
		currentProduct = null;
		families = null;
		products = null;
		options = buyService.createComboOption();

	}

	public String doGetCurrentProduct(long idProduct) {
		String surf = null;
		currentProduct = catalogService.getProductById(idProduct);
		if (currentProduct != null) {
			surf = "productDetail";

		}
		return surf;

	}

	public String doSearchDescription() {
		String surf = null;
		if (checkDescription != null) {
			products = catalogService.getProductBy("DESCRIPTION",
					checkDescription);
			surf = "products";
		}
		return surf;
	}

	public String doSearchBrand() {
		String surf = null;
		if (checkBrand != null) {
			products = catalogService.getProductBy("BRAND", checkBrand);
		}
		surf = "products";
		return surf;

	}

	public String doSearchAll() {
		String surf = null;

		currentFamily = null;
		products = catalogService.getAllProducts();
		surf = "products";
		return surf;

	}

	public String doSelectFamily() {
		String surf = null;
		Long idFamily = getIdParm("idFamily");
		currentFamily = catalogService.getFamilyById(idFamily);
		products = catalogService.getProductBy("FAMILY", idFamily);
		catalogService.getAllFamilies();
		surf = "products";
		return surf;

	}

	/**
	 * {@link CatalogService}
	 */
	@ManagedProperty(value = CatalogService.EL_NAME)
	private CatalogService catalogService;

	/**
	 * {@link BuyService}
	 */
	@ManagedProperty(value = BuyService.EL_NAME)
	private BuyService buyService;

	/**
	 * @return the currentFamily
	 */
	public FamilyDTO getCurrentFamily() {
		return currentFamily;
	}

	/**
	 * @param currentFamily
	 *            the currentFamily to set
	 */
	public void setCurrentFamily(FamilyDTO currentFamily) {
		this.currentFamily = currentFamily;
	}

	/**
	 * @return the currentProduct
	 */
	public ProductDTO getCurrentProduct() {
		return currentProduct;
	}

	/**
	 * @param currentProduct
	 *            the currentProduct to set
	 */
	public void setCurrentProduct(ProductDTO currentProduct) {
		this.currentProduct = currentProduct;
	}

	/**
	 * @return the families
	 */
	public List<FamilyDTO> getFamilies() {
		if (families == null) {
			families = catalogService.getAllFamilies();
		}
		return families;
	}

	/**
	 * @param families
	 *            the families to set
	 */
	public void setFamilies(List<FamilyDTO> families) {
		this.families = families;
	}

	/**
	 * @return the products
	 */
	public List<ProductDTO> getProducts() {
		if (products == null) {
			products = catalogService.getAllProducts();
		}
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	/**
	 * @return the checkDescription
	 */
	public String getCheckDescription() {
		return checkDescription;
	}

	/**
	 * @param checkDescription
	 *            the checkDescription to set
	 */
	public void setCheckDescription(String checkDescription) {
		this.checkDescription = checkDescription;
	}

	/**
	 * @return the checkBrand
	 */
	public String getCheckBrand() {
		return checkBrand;
	}

	/**
	 * @param checkBrand
	 *            the checkBrand to set
	 */
	public void setCheckBrand(String checkBrand) {
		this.checkBrand = checkBrand;
	}

	/**
	 * @param catalogService
	 *            the catalogService to set
	 */
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	/**
	 * @return the myTheme
	 */
	public Theme getMyTheme() {
		return myTheme;
	}

	/**
	 * @param myTheme
	 *            the myTheme to set
	 */
	public void setMyTheme(Theme myTheme) {
		this.myTheme = myTheme;
	}

	/**
	 * @return the options
	 */
	public Options getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

	/**
	 * @param buyService
	 *            the buyService to set
	 */
	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}

}
