package com.mopelo.service.dto;

import com.mopelo.common.dto.GenericDTO;

/**
 * 
 * @author guerrero
 * 
 */

public class CustomerDTO extends GenericDTO {
	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String nif;
	private String address;
	private String postalCode;
	private String provincia;
	private String email;
	private String telephone;
	private UserDTO user;

	public CustomerDTO(Long id, String name, String surname, String nif,
			String address, String postalCode, String provincia, String email,
			String telephone) {
		super(id);

		this.name = name;
		this.surname = surname;
		this.nif = nif;
		this.address = address;
		this.postalCode = postalCode;
		this.provincia = provincia;
		this.email = email;
		this.telephone = telephone;
	}

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(Long id) {
		super(id);
	}

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif
	 *            the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		final CustomerDTO other = (CustomerDTO) obj;
		if (this.getId() != other.getId()
				&& (this.getId() == null || !this.getId().equals(other.getId()))) {
			return false;
		}
		if ((this.name == null) ? (other.name != null) : !this.name
				.equals(other.name)) {
			return false;
		}
		if ((this.surname == null) ? (other.surname != null) : !this.surname
				.equals(other.surname)) {
			return false;
		}
		if ((this.nif == null) ? (other.nif != null) : !this.nif
				.equals(other.nif)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CUSTOMER[id=" + this.getId() + ",name:" + this.name
				+ ", surname:" + this.surname + ",nif:" + this.nif + "]";
	}

}
