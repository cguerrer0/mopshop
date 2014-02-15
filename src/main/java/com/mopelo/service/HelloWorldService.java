/**
 * 
 */
package com.mopelo.service;

import java.util.List;

import com.mopelo.domain.HelloWorld;
import com.mopelo.service.dto.HelloWorldDTO;

/**
 * Hello world service
 * 
 * @author cguerrero
 */
public interface HelloWorldService {

	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "helloWorldService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{helloWorldService}";

	/**
	 * Create an entity hello world
	 * 
	 * @param entity
	 *            : entity to create
	 */
	void create(HelloWorld entity);

	/**
	 * Retrieve hello world.
	 * 
	 * @return
	 */
	List<HelloWorldDTO> retrieveAll();

}
