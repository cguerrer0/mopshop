package com.mopelo.service.impl;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopelo.dao.CustomerDao;
import com.mopelo.dao.UserDao;
import com.mopelo.domain.Customer;
import com.mopelo.domain.User;
import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-global.xml" })
public class UserServiceImplTest {

	@Rule public final JUnitRuleMockery mockery = new JUnitRuleMockery();
	@Mock @Autowired private UserDao userDao;
	@Mock @Autowired private CustomerDao customerDao;
	
	private UserService userService;
	private User user;
	private Customer customer;
	
	private static final String LOGIN = "a";
	private static final String PASSWORD ="b";
	private static final CustomerDTO CUSTOMER = new CustomerDTO();
	
	@Before
	public void setUp(){
		userService = new UserServiceImpl();
		userService.setCustomerDao(customerDao);
		userService.setUserDao(userDao);
		user= new User();
		user.setLogin(LOGIN);
		user.setPassword(PASSWORD);
		customer = new Customer();
	}
	
	@Test
	public void canAddANewUser() {
		mockery.checking(new Expectations(){{
			oneOf(userDao).insert(user);
			ignoring(customerDao);
		}});
		
		userService.addNewCustomer(LOGIN, PASSWORD, CUSTOMER);
	}
	@Test
	public void addsNewCustomer(){
		mockery.checking(new Expectations(){{
			oneOf(customerDao).insert(customer);
			ignoring(userDao);
		}});
		userService.addNewCustomer(LOGIN, PASSWORD, CUSTOMER);
		
	}

}
