package com.mopelo.bean;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-global.xml" })

public class UserBeanTest {
	
	@Rule public final JUnitRuleMockery mockery = new JUnitRuleMockery();
	@Mock @Autowired private UserService userService;
	private static final String LOGIN = "a";
	private static final String PASSWORD ="b";
	private static final CustomerDTO CUSTOMER = new CustomerDTO();
	private UserBean userBean;
	
	@Before
	public void setUp(){
		userBean = new UserBean();
		userBean.setUserService(userService);
		userBean.setLogin(LOGIN);
		userBean.setPassword(PASSWORD);
		userBean.setCurrentCustomer(CUSTOMER);
	}
	
	
	@Test
	public void canAddANewUser() {
		mockery.checking(new Expectations(){{
			oneOf(userService).addNewCustomer(LOGIN, PASSWORD,CUSTOMER);
		}});
		userBean.doCreateUser();
	}
	
	@Test
	public void updateNewUserAfterAddNewUser(){
		mockery.checking(new Expectations(){{
			ignoring(userService).addNewCustomer(LOGIN, PASSWORD,CUSTOMER);
		}});
		userBean.doCreateUser();
		Assert.assertFalse(userBean.isNewUser()); 
		
	}
	
	
	

}
