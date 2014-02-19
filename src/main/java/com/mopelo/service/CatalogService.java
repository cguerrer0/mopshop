package com.mopelo.service;

import java.util.List;

import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.ProductDTO;

public interface CatalogService {
	
	static String BEAN_NAME = "catalogService";

	static String EL_NAME = "#{catalogService}";


	List<ProductDTO> getAllProducts();

	List<FamilyDTO> getAllFamilies();

	/**
	 * Get a list of Product using as a condition the field and the value.
	 * @param field String with the name of the column to query for
	 * (Could be DESCRIPTION, FAMILY, BRAND)
	 * @param value String with the value to query for
	 * @return
	 */
	List<ProductDTO> getProductBy(String field, Object value);

	FamilyDTO getFamilyById(long idFamily);

	ProductDTO getProductById(long idProduct);

}
