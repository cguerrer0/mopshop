/**
 * 
 */
package com.mopelo.common.dto;

import java.io.Serializable;

/**
 * Generico DTO
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
