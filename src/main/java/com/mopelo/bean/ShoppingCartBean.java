package com.mopelo.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.mopelo.common.bean.GenericBean;
import com.mopelo.service.BuyService;
import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.OrderDTO;

@ManagedBean
@SessionScoped
public class ShoppingCartBean extends GenericBean {

	BuyProductDTO currentBuyProduct;
	OrderDTO order;
	double totalAmount;

	@ManagedProperty(value = "#{userBean}")
	UserBean userBean;

	@ManagedProperty(value = BuyService.EL_NAME)
	private BuyService buyService;

	@PostConstruct
	public void init() {
		currentBuyProduct = null;
		order = null;
	}

	public String doAddProduct(long idProduct) {
		String surf = null;
		buyService.addProduct(idProduct, 1);
		totalAmount = buyService.calculateTotalAmount();
		return surf + "?faces-redirect=true";
	}

	public String doDeleteProduct(long idProduct) {
		String surf = null;
		buyService.deleteProduct(idProduct);
		totalAmount = buyService.calculateTotalAmount();
		return surf;
	}

	public String doUpdateShoppingCart() {
		String surf = null;
		totalAmount = buyService.calculateTotalAmount();
		return surf + "?faces-redirect=true";

	}

	public String doConfirmShoppingCart() {
		String surf = null;
		if (userBean.getCurrentCustomer() == null) {
			addErrorMessage("");// TODO you have to register
		} else {
			buyService.confirmShoppingCart();
			order = buyService.createOrder(userBean.getCurrentCustomer());
			surf = "completOrder";
		}

		return surf + "?faces-redirect=true";
	}

	public String doClearCart() {
		String surf = null;
		surf = "products";
		clearCart();
		return surf + "?faces-redirect=true";
	}

	private void clearCart() {
		buyService.clearCart();
		totalAmount = 0.0;

	}

	public String doIncNumber(long idProduct) {
		String surf = null;
		buyService.modifyNumber(idProduct, 1, "INCREASE");
		totalAmount = buyService.calculateTotalAmount();
		return surf + "?faces-redirect=true";
	}

	public String doDecNumber(long idProduct) {
		String surf = null;
		buyService.modifyNumber(idProduct, 1, "DECREASE");
		totalAmount = buyService.calculateTotalAmount();
		return surf + "?faces-redirect=true";
	}

	/**
	 * @return the products
	 */
	public List<BuyProductDTO> getProducts() {
		return buyService.getShoppingCart();
	}

	/**
	 * @return the currentBuyProduct
	 */
	public BuyProductDTO getCurrentBuyProduct() {
		return currentBuyProduct;
	}

	/**
	 * @param currentBuyProduct
	 *            the currentBuyProduct to set
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
	 * @param order
	 *            the order to set
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
	 * @param totalAmount
	 *            the totalAmount to set
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
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @param buyService
	 *            the buyService to set
	 */
	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}

}
