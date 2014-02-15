package com.mopelo.service;

import java.util.List;

import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.OrderDTO;


public interface BuyService {
	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "buyService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{buyService}";



    void initShoppingCart();

    void addProduct(long idProduct, long number);

    void decreaseNumber(long idProduct, long number);

    void incrementarCantidad(long idProduct, long number);

    void clearCart();

    //void confirmarCarro() throws ExcepcionExistencias;

    void deleteProduct(long idProduct);

    void updateNumber(long idProduct, long newNumber);

   //boolean productoDisponible(long idProducto, long cantidad);

    //void establecerCliente(long idCliente);

    OrderDTO createOrder();

    List<BuyProductDTO> getShoppingCart();

    double calcularImporteTotal();


}
