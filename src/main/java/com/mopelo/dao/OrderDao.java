/**
 * 
 */
package com.mopelo.dao;

import java.util.List;

import com.mopelo.common.dao.GenericDao;
import com.mopelo.domain.Order;
import com.mopelo.domain.OrderRow;
import com.mopelo.util.Entry;

/**
 * DAO of ORder
 * 
 * @author cguerrero
 */
public interface OrderDao extends GenericDao<Order> {

	public void insertOrderRow(List<OrderRow> orderRows);

	public List<Entry> getFamiliesWithOrder();

	public List<Entry> getNumberProductByBrandAndFamily(String id);

	public List<String> getBrandWithOrder();

}
