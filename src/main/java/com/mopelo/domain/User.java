package com.mopelo.domain;

import java.util.Date;

import com.mopelo.common.domain.GenericEntity;

/**
 * 
 * @author guerrero
 * 
 */
public class User extends GenericEntity {

	public User(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private Date date;
	private Date lastAccess;
	private UserType userType;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the lastAccess
	 */
	public Date getLastAccess() {
		return lastAccess;
	}

	/**
	 * @param lastAccess
	 *            the lastAccess to set
	 */
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (this.getId() != other.getId()
				&& (this.getId() == null || !this.getId().equals(other.getId()))) {
			return false;
		}
		if ((this.login == null) ? (other.login != null) : !this.login
				.equals(other.login)) {
			return false;
		}
		if (this.userType != other.userType
				&& (this.userType == null || !this.userType
						.equals(other.userType))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "USER[id=" + this.getId() + ",login:" + this.login + ",tipo:"
				+ this.userType + "]";
	}

}
