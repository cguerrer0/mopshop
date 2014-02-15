/**
 * 
 */
package com.mopelo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.UserDao;
import com.mopelo.domain.User;
import com.mopelo.service.CatalogService;
import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.UserDTO;
import com.mopelo.util.MapperUtils;

/**
 * Implementation of {@link CatalogService}
 * 
 * @author cguerrero
 */
@Service(UserService.BEAN_NAME)
public class UserServiceImpl implements  UserService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link userDao}
	 */
    @Autowired
	private UserDao userDao;
    /**
	 * {@link productDao}
	 */
    @Autowired
    private CustomerDao customerDao;
	/* ************************************ */
	/* Methods */
	/* ************************************ */

	@Override
	public boolean existUser(String login) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public CustomerDTO addNewCustomer(String login, String password,CustomerDTO customerData) {
		UserDTO userAux= new UserDTO();
		userAux.setLogin(login);
		userAux.setPassword(password);
		userDao.create((User)MapperUtils.map(userAux, User.class));
		return null;
	}
	@Override
	public CustomerDTO getCustomer(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * @param customerDao the customerDao to set
	 */
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
 
   
	
	
}
