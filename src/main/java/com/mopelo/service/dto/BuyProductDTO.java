package com.mopelo.service.dto;

import java.io.Serializable;

public class BuyProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDTO product;
	private long number;

	public BuyProductDTO() {
		super();
	}

	public BuyProductDTO(ProductDTO product, long number) {

		this.product = product;
		this.number = number;
	}

	public BuyProductDTO(ProductDTO productDTO, int number) {
		product = productDTO;
		this.number = number;
	}

	/**
	 * @return the product
	 */
	public ProductDTO getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	/**
	 * @return the number
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(long number) {
		this.number = number;
	}

	public void increaseNumber(long inc) {
		this.number += inc;
	}

	public void decreaseNumber(long dec) {
		this.number -= dec;
	}
}
