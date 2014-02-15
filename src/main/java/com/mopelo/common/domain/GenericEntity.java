/**
 * 
 */
package com.mopelo.common.domain;

import java.io.Serializable;

/**
 * Business Entity
 * 
 * @author cguerrero
 */
public abstract class GenericEntity implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id.
	 */
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public GenericEntity(Long id) {
		super();
		this.id = id;
	}

	public GenericEntity() {
		// TODO Auto-generated constructor stub
	}
	

}
