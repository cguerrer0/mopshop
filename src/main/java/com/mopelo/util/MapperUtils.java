/**
 * 
 */
package com.mopelo.util;

import java.util.List;

import ma.glasnost.orika.MapperFacade;

import com.mopelo.mapper.MopeloMapper;

/**
 * Utils for Mapping between objects.
 * 
 * @author cguerrero
 */
public final class MapperUtils {


	/**
	 * Mapper.
	 */
	private static MapperFacade mopeloMapper;

	/**
	 * @return the Mapper
	 */
	private static MapperFacade getMopeloMapper() {
		if (mopeloMapper == null) {
			mopeloMapper = new MopeloMapper();
		}
		return mopeloMapper;
	}

	/**
	 * Convert a collection to a list.
	 * 
	 * @param source
	 *            : collection source
	 * @param destinationClass
	 *            : destination entity class in list
	 * @return list of destination class
	 */
	public static <T, D> List<T> mapAsList(Iterable<D> source,
			Class<T> destinationClass) {
		return getMopeloMapper().mapAsList(source, destinationClass);
	}

	/**
	 * Map the source into a new object of destination class type.
	 * 
	 * @param source
	 *            : source object
	 * @param destinationClass
	 *            : type of the new object
	 * @return new object
	 */
	public static <T, D> T map(D source, Class<T> destinationClass) {
		return getMopeloMapper().map(source, destinationClass);
	}

}
