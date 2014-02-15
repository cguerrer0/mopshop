/**
 * 
 */
package com.mopelo.common.dto;

import java.io.Serializable;

/**
 * Common business dto
 * 
 * @author cguerrero
 */
public abstract class GenericDTO implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 3886269150595934285L;
	


	/**
	 * Id.
	 */
	private Long id;

	public GenericDTO(Long id) {
		this.id = id;
	}
	

	public GenericDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


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

	

}
