package com.mopelo.service;

import java.util.List;

import com.googlecode.wickedcharts.highcharts.options.Options;
import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.OrderDTO;

public interface BuyService {
	
	static String BEAN_NAME = "buyService";

	static String EL_NAME = "#{buyService}";

	void initShoppingCart();

	void addProduct(long idProduct, long number);

	void modifyNumber(long idProduct, long number, String operation);

	void clearCart();

	void confirmShoppingCart();

	void deleteProduct(long idProduct);

	OrderDTO createOrder(CustomerDTO customerDTO);

	List<BuyProductDTO> getShoppingCart();

	double calculateTotalAmount();

	Options createComboOption();

}
