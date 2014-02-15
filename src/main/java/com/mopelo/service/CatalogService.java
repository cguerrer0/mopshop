package com.mopelo.service;

import java.util.List;

import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.ProductDTO;


public interface CatalogService {
	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "catalogService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{catalogService}";


	/**
	 * Retrieve all products.
	 * 
	 * @return
	 */
	List<ProductDTO> retrieveAllProducts();
	/**
	 * Retrieves all families.
	 * @return
	 */
	List<FamilyDTO> retrieveAllFamilies();

}
