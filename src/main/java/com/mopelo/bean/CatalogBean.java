package com.mopelo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import com.mopelo.service.CatalogService;
import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.ProductDTO;

@ManagedBean
public class CatalogBean {
	
    private FamilyDTO currentFamily = null;
    private ProductDTO currentProduct = null;
    private List<FamilyDTO> families = null;
    private List<ProductDTO> products = null;
    private String checkDescription;
    private String checkBrand;
    
    
    
    public String doCheckCurrentProduct(long idProduct){
    	String surf= null;
    	surf="productDetail";
    	
    	return surf;
    	
    }
  
    
    public String doSearchDescription(){
    	String surf= null;
    	surf="productDetail";
    	
    	return surf;
    	
    	
    	
    }
    public String doSearchBrand(){
    	String surf= null;
    	surf="productDetail";
    	
    	return surf;
    	
    	
    	
    }
    public String doSearchAll(){
    	String surf= null;
    	surf="productDetail";
    	
    	return surf;
    	
    	
    	
    }
    
    public String doSelectFamily(){
    	String surf= null;
    	surf="productDetail";
    	catalogService.retrieveAllFamilies();
    	
    	
    	return surf;
    	
    	
    	
    }
	/**
	 * {@link CatalogService}
	 */
	@ManagedProperty(value = CatalogService.EL_NAME)
	private CatalogService catalogService;
    
	/**
	 * @return the currentFamily
	 */
	public FamilyDTO getCurrentFamily() {
		return currentFamily;
	}
	/**
	 * @param currentFamily the currentFamily to set
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
	 * @param currentProduct the currentProduct to set
	 */
	public void setCurrentProduct(ProductDTO currentProduct) {
		this.currentProduct = currentProduct;
	}
	/**
	 * @return the families
	 */
	public List<FamilyDTO> getFamilies() {
		return catalogService.retrieveAllFamilies();
	}
	/**
	 * @param families the families to set
	 */
	public void setFamilies(List<FamilyDTO> families) {
		this.families = families;
	}
	/**
	 * @return the products
	 */
	public List<ProductDTO> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
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
	 * @param checkDescription the checkDescription to set
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
	 * @param checkBrand the checkBrand to set
	 */
	public void setCheckBrand(String checkBrand) {
		this.checkBrand = checkBrand;
	}


	/**
	 * @param catalogService the catalogService to set
	 */
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

    
    
    

}
