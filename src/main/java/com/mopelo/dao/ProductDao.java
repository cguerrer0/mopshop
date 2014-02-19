package com.mopelo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mopelo.common.dao.GenericDao;
import com.mopelo.domain.Product;

/**
 * DAO of Product
 * 
 * @author cguerrero
 */
public interface ProductDao extends GenericDao<Product> {

	List<Product> getByFieldValue(@Param("field") String field,
			@Param("value") Object value);

}
