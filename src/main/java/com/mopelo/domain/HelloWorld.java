/**
 * 
 */
package com.mopelo.domain;

import com.mopelo.common.domain.GenericEntity;

/**
 * Hello entity.
 * 
 * @author cguerrero
 */
public class HelloWorld extends GenericEntity {

	public HelloWorld(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1874597988200405724L;

	/**
	 * Last name.
	 */
	private String lastName;

	/**
	 * First name.
	 */
	private String firstName;

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
