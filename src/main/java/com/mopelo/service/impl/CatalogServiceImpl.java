/**
 * 
 */
package com.mopelo.service.impl;

import java.util.ArrayList;
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
 * 
 * @author cguerrero
 */
@Service(CatalogService.BEAN_NAME)
public class CatalogServiceImpl implements CatalogService {


	@Autowired
	private FamilyDao familyDao;

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public List<ProductDTO> getAllProducts() {
		LoggerUtils.logStartMethod("getAllProducts");
		List<ProductDTO> lProductDTOs = new ArrayList<ProductDTO>();
		List<Product> lProductsEntity = productDao.getAll();
		if (lProductsEntity != null) {
			lProductDTOs = MapperUtils.mapAsList(lProductsEntity,
					ProductDTO.class);
		}
		LoggerUtils.logEndMethod("getAllProducts");
		return lProductDTOs;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public List<FamilyDTO> getAllFamilies() {
		LoggerUtils.logStartMethod("getAllFamilies");
		List<Family> lFamilyEntity = familyDao.getAll();
		List<FamilyDTO> lFamilyDTO = new ArrayList<FamilyDTO>();
		if (lFamilyEntity != null) {
			lFamilyDTO = MapperUtils.mapAsList(lFamilyEntity, FamilyDTO.class);
		}
		LoggerUtils.logEndMethod("getAllFamilies");
		return lFamilyDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public List<ProductDTO> getProductBy(String field, Object value) {
		LoggerUtils.logStartMethod("getProductBy");
		List<ProductDTO> lProductDTOs = new ArrayList<ProductDTO>();
		List<Product> lProductsEntity = productDao
				.getByFieldValue(field, value);
		if (lProductsEntity != null) {
			lProductDTOs = MapperUtils.mapAsList(lProductsEntity,
					ProductDTO.class);
		}
		LoggerUtils.logEndMethod("getProductBy");
		return lProductDTOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public FamilyDTO getFamilyById(long idFamily) {
		LoggerUtils.logStartMethod("getFamilyById");
		FamilyDTO familyDTO = new FamilyDTO();
		Family familyEntity = familyDao.getById(idFamily);
		if (familyEntity != null) {
			familyDTO = MapperUtils.map(familyEntity, FamilyDTO.class);
		}
		LoggerUtils.logEndMethod("getFamilyById");
		return familyDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  readOnly = true)
	public ProductDTO getProductById(long idProduct) {
		LoggerUtils.logStartMethod("getProductById");
		ProductDTO productDTO = null;
		Product productEntity = productDao.getById(idProduct);
		if (productEntity != null) {
			productDTO = MapperUtils.map(productEntity, ProductDTO.class);
		}
		LoggerUtils.logEndMethod("getProductById");
		return productDTO;
	}

}
