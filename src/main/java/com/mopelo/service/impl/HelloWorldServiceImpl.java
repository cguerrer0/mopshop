/**
 * 
 */
package com.mopelo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mopelo.dao.HelloWorldDao;
import com.mopelo.domain.HelloWorld;
import com.mopelo.service.HelloWorldService;
import com.mopelo.service.dto.HelloWorldDTO;
import com.mopelo.util.LoggerUtils;
import com.mopelo.util.MapperUtils;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author cguerrero
 */
@Service(HelloWorldService.BEAN_NAME)
public class HelloWorldServiceImpl implements HelloWorldService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldDao}
	 */
    @Autowired
	private HelloWorldDao helloWorldDao;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(HelloWorld entity) {
		LoggerUtils.logStartMethod("create");
		helloWorldDao.create(entity);
		LoggerUtils.logEndMethod("create");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<HelloWorldDTO> retrieveAll() {
		LoggerUtils.logStartMethod("retrieveAll");
		List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
		@SuppressWarnings("unchecked")
		List<HelloWorldDTO> returnValue = (List<HelloWorldDTO>) MapperUtils.mapAsList(listEntities, HelloWorldDTO.class);
		LoggerUtils.logEndMethod("retrieveAll");
		return returnValue;
	}

}
