/**
 * 
 */
package com.mopelo.service.impl;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.OrderDao;
import com.mopelo.dao.ProductDao;
import com.mopelo.service.BuyService;
import com.mopelo.service.dto.BuyProductDTO;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.OrderDTO;

/**
 * Implementation of {@link BuyService}
 * 
 * @author cguerrero
 */
@Service(BuyService.BEAN_NAME)
public class BuyServiceImpl implements  BuyService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

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
      {@link orderDao}
	 */
    @Autowired
    private OrderDao orderDao;
    
    
    private List<BuyProductDTO> shoppingCart = null;
    private CustomerDTO customer = null;
    
    
    
   	/* ************************************ */
   	/* Methods */
   	/* ************************************ */
    
    public void initShoppingCart(){
    	this.shoppingCart = new Vector<BuyProductDTO>();
    	this.customer= null;
    	
    }



	@Override
	public void addProduct(long idProduct, long number) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void decreaseNumber(long idProduct, long number) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void incrementarCantidad(long idProduct, long number) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteProduct(long idProduct) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateNumber(long idProduct, long newNumber) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public OrderDTO createOrder() {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public double calcularImporteTotal() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<BuyProductDTO> getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}





	
	
}
