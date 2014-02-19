/**
 * 
 */
package com.mopelo.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.UserDao;
import com.mopelo.domain.Customer;
import com.mopelo.domain.User;
import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.UserDTO;
import com.mopelo.util.MapperUtils;

/**
 * 
 * @author cguerrero
 */
@Service(UserService.BEAN_NAME)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerDao customerDao;

	@Override
	public boolean existUser(String login) {

		return (userDao.getUserByLogin(login) != null);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public boolean checkUser(String login, String password) {
		User user;
		boolean result = false;
		user = userDao.getUserByLogin(login);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public CustomerDTO addNewCustomer(String login, String password,
			CustomerDTO customerData) {
		UserDTO userData = new UserDTO();
		userData.setLogin(login);
		userData.setPassword(password);
		User user = MapperUtils.map(userData, User.class);
		userDao.insert(user);
		Customer customer = MapperUtils.map(customerData, Customer.class);
		customer.setUser(user);
		userData.setId(user.getId());
		customerDao.insert(customer);
		customerData.setId(customer.getId());
		customerData.setUser(userData);
		return customerData;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public CustomerDTO getCustomer(String login) {
		CustomerDTO customerDTO = null;
		Customer customerEntity = customerDao.getCustomerByLogin(login);
		if (customerEntity != null) {
			customerDTO = MapperUtils.map(customerEntity, CustomerDTO.class);
			if (customerEntity.getUser() != null) {
				customerDTO.setUser(MapperUtils.map(customerEntity.getUser(),
						UserDTO.class));
			}

		}
		return customerDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO updateLastAccess(long idUser) {
		UserDTO userDTO = null;
		User userEntity = userDao.getById(idUser);
		if (userEntity != null) {
			userEntity.setLastAccess(Calendar.getInstance().getTime());
			userDao.update(userEntity);
			userDTO = MapperUtils.map(userEntity, UserDTO.class);
		}
		return userDTO;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @param customerDao
	 *            the customerDao to set
	 */
	@Override
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
