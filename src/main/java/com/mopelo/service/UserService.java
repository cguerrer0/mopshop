package com.mopelo.service;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.UserDao;
import com.mopelo.service.dto.CustomerDTO;

public interface UserService {
	
	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "userService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{userService}";
	
	
    boolean checkUser(String login, String password);

    CustomerDTO getCustomer(String login);

    CustomerDTO addNewCustomer(String login, String password, CustomerDTO customerData);

    //Cliente actualizarDatosCliente(Cliente datosCliente);

    //Usuario actualizarPassword(long idUsuario, String password);

    boolean existUser(String login);

    //SUser actualizarUltimoAcceso(long idUsuario);
    
    void setUserDao(UserDao userDao);
    void setCustomerDao(CustomerDao customerDao);

}
