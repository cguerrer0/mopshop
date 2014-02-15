package com.mopelo.service.dto;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.mopelo.common.dto.GenericDTO;
/**
 * 
 * @author guerrero
 *
 */
public class OrderDTO extends GenericDTO {
	
	

	private static final long serialVersionUID = 1L;
	  
	    
	    private CustomerDTO customer;
	    private Date date;
	    private OrderStatusDTO status;
	    // Operaciones en cascada a traves de la relacion 1:N
	    // Carga retardada (LAZY) de la lista de LineaPedido
	    //    se cargará al hacer el getLineasPedido (pero sólo desde un EJB)
	    private List<OrderRowDTO> lineRows;

	    private Double totalPedido;  // No se almacena en BD



	   
	    public OrderDTO() {
			super();
			// TODO Auto-generated constructor stub
		}





		public OrderDTO(CustomerDTO customer, Date date, OrderStatusDTO status) {
			super();
			this.customer = customer;
			this.date = date;
			this.status = status;
			this.lineRows = new Vector<OrderRowDTO>();
	        this.totalPedido = 0.0;
		}





		public OrderDTO(Long id) {
			super(id);
			this.totalPedido = 0.0;
		}
	
	    public OrderDTO(CustomerDTO customer, Date date,
				OrderStatusDTO status, List<OrderRowDTO> lineRows) {
			this(customer,date,status);
			this.lineRows = lineRows;
			this.totalPedido = addTotalRows();
		}

	   

	    private Double addTotalRows(){
	        double suma = 0;
	        for (OrderRowDTO row: lineRows){
	            suma += row.getTotalRow();
	        }

	        return (suma);
	    }

	    public void anadirLineaPedido(OrderRowDTO row){
	        if (this.lineRows == null){
	            System.err.println("order rows is null");
	        }

	        if (row == null){
	        System.err.println("row is null");
	        }

	        this.lineRows.add(row);
	        this.totalPedido += row.getTotalRow();
	    }



	    /**
		 * @return the customer
		 */
		public CustomerDTO getCustomer() {
			return customer;
		}





		/**
		 * @param customer the customer to set
		 */
		public void setCustomer(CustomerDTO customer) {
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
		public OrderStatusDTO getStatus() {
			return status;
		}





		/**
		 * @param status the status to set
		 */
		public void setStatus(OrderStatusDTO status) {
			this.status = status;
		}





		/**
		 * @return the lineRows
		 */
		public List<OrderRowDTO> getLineRows() {
			return lineRows;
		}





		/**
		 * @param lineRows the lineRows to set
		 */
		public void setLineRows(List<OrderRowDTO> lineRows) {
			this.lineRows = lineRows;
		}





		/**
		 * @return the totalPedido
		 */
		public Double getTotalPedido() {
			return totalPedido;
		}





		/**
		 * @param totalPedido the totalPedido to set
		 */
		public void setTotalPedido(Double totalPedido) {
			this.totalPedido = totalPedido;
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
	        if (!(object instanceof OrderDTO)) {
	            return false;
	        }
	        OrderDTO other = (OrderDTO) object;
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
