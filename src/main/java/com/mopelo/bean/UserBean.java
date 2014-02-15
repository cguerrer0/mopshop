package com.mopelo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.UserDTO;

@ManagedBean
public class UserBean {

	private UserDTO currentUser;
	private CustomerDTO currentCustomer;
	private String login;
	private String password;
	private String password2;
	private boolean newUser;
	
	
	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link userService}
	 */
	@ManagedProperty(value = UserService.EL_NAME)
	private UserService userService;

	
	
   @PostConstruct
   public void init() {
	   currentCustomer = new CustomerDTO();
	   currentUser = new UserDTO();
	   login ="";
	   password = "";
	   password2 = "";
	   newUser = true;
	   
   }
	
	public String doLogin() {
		String surf = null;
		
		if(userService.checkUser(login, password)){
			currentCustomer = userService.getCustomer(login);
			//currentUser = currentCustomer.get
			newUser=false;
			surf = "products" ;
			
		}else{
			
			surf = "products" ;//login
		}
	
		return surf+"?faces-redirect=true";
	}
	
	public String doNewUser() {
		String surf = null;
		
		surf="clientPage";
	
		return surf+"?faces-redirect=true";
	}
	
	
	public String doCreateUser(){
		String surf = null;
	
		userService.addNewCustomer(login, password, currentCustomer);
		newUser=false;
		surf="clientPage";
		
		return surf+"?faces-redirect=true";
		
	}
	
	public String doUpdateUser(){
		String surf = null;
		surf="clientPage";
		
		return surf+"?faces-redirect=true";
		
	}


	/**
	 * @return the currentUser
	 */
	public UserDTO getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(UserDTO currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentCustomer
	 */
	public CustomerDTO getCurrentCustomer() {
		return currentCustomer;
	}

	/**
	 * @param currentCustomer the currentCustomer to set
	 */
	public void setCurrentCustomer(CustomerDTO currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the newUser
	 */
	public boolean isNewUser() {
		return newUser;
	}

	/**
	 * @param newUser the newUser to set
	 */
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	
	
}
