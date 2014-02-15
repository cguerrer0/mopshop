package com.mopelo.service.dto;

import com.mopelo.common.domain.GenericEntity;

public class ProductDTO extends GenericEntity {
	  public ProductDTO(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1L;
	
	    private String  description;
	    private String  detail;
	    private Double  price;
	    private Integer stock;
	    private String  brand;
	    private String  model;
	    private FamilyDTO family;

	   

	    /**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the detail
		 */
		public String getDetail() {
			return detail;
		}

		/**
		 * @param detail the detail to set
		 */
		public void setDetail(String detail) {
			this.detail = detail;
		}

		/**
		 * @return the price
		 */
		public Double getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(Double price) {
			this.price = price;
		}

		/**
		 * @return the stock
		 */
		public Integer getStock() {
			return stock;
		}

		/**
		 * @param stock the stock to set
		 */
		public void setStock(Integer stock) {
			this.stock = stock;
		}

		/**
		 * @return the brand
		 */
		public String getBrand() {
			return brand;
		}

		/**
		 * @param brand the brand to set
		 */
		public void setBrand(String brand) {
			this.brand = brand;
		}

		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}

		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		

	    /**
		 * @return the family
		 */
		public FamilyDTO getFamily() {
			return family;
		}

		/**
		 * @param family the family to set
		 */
		public void setFamily(FamilyDTO family) {
			this.family = family;
		}

		@Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final ProductDTO other = (ProductDTO) obj;
	        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
	            return false;
	        }
	        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
	            return false;
	        }
	        if ((this.detail == null) ? (other.detail != null) : !this.detail.equals(other.detail)) {
	            return false;
	        }
	        if (this.price != other.price && (this.price == null || !this.price.equals(other.price))) {
	            return false;
	        }
	        if (this.stock != other.stock) {
	            return false;
	        }
	        return true;
	    }


		@Override
	    public String toString() {
	        return "PRODUCT[id:"+this.getId()+",descrip:"+this.description+",precio:"+this.price+"]";
	    }



	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash = 59 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
	        return hash;
	    }



}
