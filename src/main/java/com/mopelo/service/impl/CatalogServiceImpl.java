/**
 * 
 */
package com.mopelo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mopelo.dao.FamilyDao;
import com.mopelo.dao.ProductDao;
import com.mopelo.domain.Family;
import com.mopelo.domain.Product;
import com.mopelo.service.CatalogService;
import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.ProductDTO;
import com.mopelo.util.LoggerUtils;
import com.mopelo.util.MapperUtils;

/**
 * Implementation of {@link CatalogService}
 * 
 * @author cguerrero
 */
@Service(CatalogService.BEAN_NAME)
public class CatalogServiceImpl implements  CatalogService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link FamilyDao}
	 */
    @Autowired
	private FamilyDao familyDao;
    /**
	 * {@link productDao}
	 */
    @Autowired
    private ProductDao productDao;
	/* ************************************ */
	/* Methods */
	/* ************************************ */
 
    /**
     * Method to retrieve all the products.
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ProductDTO> retrieveAllProducts() {
		LoggerUtils.logStartMethod("retrieveAll");
		List<Product> listEntities = productDao.retrieveAll();
		@SuppressWarnings("unchecked")
		List<ProductDTO> returnValue = (List<ProductDTO>) MapperUtils.mapAsList(listEntities, ProductDTO.class);
		LoggerUtils.logEndMethod("retrieveAll");
		return returnValue;
	}
	
	/**
	 * Method to retrieve all the families
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<FamilyDTO> retrieveAllFamilies() {
		LoggerUtils.logStartMethod("retrieveAll");
		List<Family> listEntities = familyDao.retrieveAll();
		@SuppressWarnings("unchecked")
		List<FamilyDTO> returnValue = (List<FamilyDTO>) MapperUtils.mapAsList(listEntities, FamilyDTO.class);
		LoggerUtils.logEndMethod("retrieveAll");
		return returnValue;
	}
	
	
}
