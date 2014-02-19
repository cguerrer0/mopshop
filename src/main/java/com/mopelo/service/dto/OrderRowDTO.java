package com.mopelo.service.dto;

import com.mopelo.common.domain.GenericEntity;

/**
 * 
 * @author guerrero
 * 
 */
public class OrderRowDTO extends GenericEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrderDTO order;
	private ProductDTO product;
	private Long number;
	private Double price;
	private Double discount;

	private Double totalRow; // No se escribe en BD

	public OrderRowDTO(Long id) {
		super(id);
	}

	public OrderRowDTO() {
		super();
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
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
	public Long getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Long number) {
		this.number = number;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the totalRow
	 */
	public Double getTotalRow() {
		return totalRow;
	}

	/**
	 * @param totalRow
	 *            the totalRow to set
	 */
	public void setTotalRow(Double totalRow) {
		this.totalRow = totalRow;
	}

	/**
	 * @return the order
	 */
	public OrderDTO getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	private void totalRowCalculation() {
		if ((this.number != null) && (this.price != null)
				&& (this.discount != null)) {
			totalRow = (number * price * ((100 - discount) / 100));
		} else {
			this.totalRow = 0.0;
		}
	}

	public OrderRowDTO(OrderDTO order, ProductDTO product, Long number,
			Double price, Double discount) {

		this.order = order;
		this.product = product;
		this.number = number;
		this.price = price;
		this.discount = discount;
		totalRowCalculation();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final OrderRowDTO other = (OrderRowDTO) obj;
		if (this.getId() != other.getId()
				&& (this.getId() == null || !this.getId().equals(other.getId()))) {
			return false;
		}
		if (this.order != other.order
				&& (this.order == null || !this.order.equals(other.order))) {
			return false;
		}
		if (this.product != other.product
				&& (this.product == null || !this.product.equals(other.product))) {
			return false;
		}
		if (this.number != other.number) {
			return false;
		}
		if (this.price != other.price) {
			return false;
		}
		if (this.discount != other.discount) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ORDER_ROW[id=" + this.getId() + ",order:" + this.order.getId()
				+ ",product:" + this.product.getId() + ",number:" + this.number
				+ ",total:" + this.getTotalRow() + "]";
	}

}
