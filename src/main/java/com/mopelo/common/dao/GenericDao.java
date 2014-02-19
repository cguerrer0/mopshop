/**
 * 
 */
package com.mopelo.common.dao;

import java.util.List;

import com.mopelo.common.domain.GenericEntity;

/**
 * Generic DAO Interface. CRUD methods.
 * 
 * @author cguerrero
 */
public interface GenericDao<GE extends GenericEntity> {

	/**
	 * Insert in database
	 * 
	 * @param entity
	 * @return entity persisted
	 */
	Long insert(GE entity);

	/**
	 * Retrieve from database by id
	 * 
	 * @param id
	 * @return
	 */
	GE getById(Long id);

	/**
	 * Retrieve all entries from database
	 * 
	 * @return
	 */
	List<GE> getAll();

	/**
	 * Update entity in database
	 * 
	 * @param entity
	 *            : entity to update
	 * 
	 */
	void update(GE entity);

	/**
	 * Delete from database by id
	 * 
	 * @param id
	 *            : entity's id to delete
	 */
	void deleteById(Long id);

}
