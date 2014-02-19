package com.mopelo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.mopelo.common.bean.GenericBean;
import com.mopelo.service.UserService;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.UserDTO;

@ManagedBean
@SessionScoped
public class UserBean extends GenericBean {

	private UserDTO currentUser;
	private CustomerDTO currentCustomer;
	private String login;
	private String password;
	private String password2;
	private boolean newUser;


	@ManagedProperty(value = UserService.EL_NAME)
	private UserService userService;
	

	
	@PostConstruct
	public void init() {
		currentCustomer = new CustomerDTO();
		currentUser = new UserDTO();
		login = "";
		password = "";
		password2 = "";
		newUser = true;

	}
	
	public String doLogin() {
		String surf = null;

		if (userService.checkUser(login, password)) {
			currentCustomer = userService.getCustomer(login);
			currentUser = currentCustomer.getUser();
			newUser = false;
			surf = "products";

		} else {

			surf = "login";
		}

		return surf + "?faces-redirect=true";
	}

	public String doLogout() {
		String surf = null;
		surf = "products";
		if (currentUser != null) {
			userService.updateLastAccess(currentUser.getId());

		}
		init();
		return surf + "?faces-redirect=true";

	}

	public String doNewUser() {
		String surf = null;
		surf = "clientPage";
		init();
		return surf + "?faces-redirect=true";
	}

	public String doCreateUser() {
		String surf = null;
		if (!password.equals(password2)) {
			 //addErrorMessage("");
		} else if (userService.existUser(login)) {
			 //addErrorMessage("");
		} else {
			newUser = false;
			currentCustomer = userService.addNewCustomer(login, password,
					currentCustomer);
			currentUser = currentCustomer.getUser();
			surf = "products";
		}
		return surf;
	}

	public String doUpdateUser() {
		String surf = null;
		surf = "clientPage";
		//TODO implement method to update the user
		return surf + "?faces-redirect=true";

	}

	public String doCheckProfile() {
		String surf = null;
		surf = "clientPage";
		login = currentUser.getLogin();
		password = currentUser.getPassword();
		password2 = password;
		currentCustomer = userService.getCustomer(login);

		return surf + "?faces-redirect=true";

	}

	/**
	 * @return the currentUser
	 */
	public UserDTO getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser
	 *            the currentUser to set
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
	 * @param currentCustomer
	 *            the currentCustomer to set
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
	 * @param login
	 *            the login to set
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
	 * @param password
	 *            the password to set
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
	 * @param password2
	 *            the password2 to set
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
	 * @param newUser
	 *            the newUser to set
	 */
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
