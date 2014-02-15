package com.mopelo.domain;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.mopelo.common.domain.GenericEntity;
/**
 * 
 * @author guerrero
 *
 */
public class Order extends GenericEntity {
	
	

	private static final long serialVersionUID = 1L;
	  
	    
	    private Customer customer;
	    private Date date;
	    private OrderStatus status;
	    // Operaciones en cascada a traves de la relacion 1:N
	    // Carga retardada (LAZY) de la lista de LineaPedido
	    //    se cargará al hacer el getLineasPedido (pero sólo desde un EJB)
	    private List<OrderRow> orderRows;

	    private Double totalOrder;  // No se almacena en BD



	   
	    public Order(Customer customer, Date date, OrderStatus status) {
			super();
			this.customer = customer;
			this.date = date;
			this.status = status;
			this.orderRows = new Vector<OrderRow>();
	        this.totalOrder = 0.0;
		}





		public Order(Long id) {
			super(id);
			this.totalOrder = 0.0;
		}
	
	    public Order(Customer customer, Date date,
				OrderStatus status, List<OrderRow> orderRows) {
			this(customer,date,status);
			this.orderRows = orderRows;
			this.totalOrder = addTotalRows();
		}

	   

	    private Double addTotalRows(){
	        double suma = 0;
	        for (OrderRow row: orderRows){
	            suma += row.getTotalRow();
	        }

	        return (suma);
	    }

	    public void anadirLineaPedido(OrderRow row){
	        if (this.orderRows == null){
	            System.err.println("order rows is null");
	        }

	        if (row == null){
	        System.err.println("row is null");
	        }

	        this.orderRows.add(row);
	        this.totalOrder += row.getTotalRow();
	    }



	    /**
		 * @return the customer
		 */
		public Customer getCustomer() {
			return customer;
		}





		/**
		 * @param customer the customer to set
		 */
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}





		/**
		 * @return the date
		 */
		public Date getDate() {
			return date;
		}





		/**
		 * @param date the date to set
		 */
		public void setDate(Date date) {
			this.date = date;
		}





		/**
		 * @return the status
		 */
		public OrderStatus getStatus() {
			return status;
		}





		/**
		 * @param status the status to set
		 */
		public void setStatus(OrderStatus status) {
			this.status = status;
		}








		/**
		 * @return the orderRows
		 */
		public List<OrderRow> getOrderRows() {
			return orderRows;
		}





		/**
		 * @param orderRows the orderRows to set
		 */
		public void setOrderRows(List<OrderRow> orderRows) {
			this.orderRows = orderRows;
		}





		/**
		 * @return the totalOrder
		 */
		public Double getTotalOrder() {
			return totalOrder;
		}





		/**
		 * @param totalOrder the totalOrder to set
		 */
		public void setTotalOrder(Double totalOrder) {
			this.totalOrder = totalOrder;
		}





		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (this.getId() != null ? this.getId().hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Order)) {
	            return false;
	        }
	        Order other = (Order) object;
	        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "ORDER[id="+this.getId()+"customer:"+this.customer.getId()+",date:"+this.date.toString()+"]";
	    }


}
