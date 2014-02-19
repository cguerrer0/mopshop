package com.mopelo.service;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.UserDao;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.UserDTO;

public interface UserService {

	static String BEAN_NAME = "userService";

	static String EL_NAME = "#{userService}";

	boolean checkUser(String login, String password);

	CustomerDTO getCustomer(String login);

	CustomerDTO addNewCustomer(String login, String password,
			CustomerDTO customerData);

	UserDTO updateLastAccess(long idUser);

	boolean existUser(String login);

	void setUserDao(UserDao userDao);

	void setCustomerDao(CustomerDao customerDao);

}
