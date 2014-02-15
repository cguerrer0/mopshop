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
public interface GenericDao<BE extends GenericEntity> {

	/**
	 * Create in database
	 * 
	 * @param entity
	 * @return entity persisted
	 */
	Long create(BE entity);

	/**
	 * Retrieve from database by id
	 * 
	 * @param id
	 * @return
	 */
	BE retrieveById(Long id);

	/**
	 * Retrieve all entries from database
	 * 
	 * @return
	 */
	List<BE> retrieveAll();

	/**
	 * Update entity in database
	 * 
	 * @param entity
	 *            : entity to update
	 * @return persisted entity
	 */
	BE update(BE entity);

	/**
	 * Delete from database by id
	 * 
	 * @param id
	 *            : entity's id to delete
	 */
	void deleteById(Long id);

}
