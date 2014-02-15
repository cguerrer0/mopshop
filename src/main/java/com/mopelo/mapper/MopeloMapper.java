/**
 * 
 */
package com.mopelo.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.mopelo.domain.Family;
import com.mopelo.domain.HelloWorld;
import com.mopelo.domain.Product;
import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.HelloWorldDTO;
import com.mopelo.service.dto.ProductDTO;
/**
 * MopeloMapper
 * 
 * @author cguerrero
 */
public class MopeloMapper extends ConfigurableMapper {

	@Override
	public void configure(MapperFactory mapperFactory) {
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
				.classMap(HelloWorld.class, HelloWorldDTO.class)
				.field("lastName", "lastName")
				.field("firstName", "firstName")
				.toClassMap());
		
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
				.classMap(HelloWorldDTO.class, HelloWorld.class)
				
				.field("lastName", "lastName")
				.field("firstName", "firstName")
				.toClassMap());
		
		
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
						.classMap(Product.class, ProductDTO.class)
						.field("id", "id")
						.field("description", "description")
						.field("detail", "detail")
						.field("price", "price")
						.field("stock", "stock")
						.field("brand", "brand")
						.field("model", "model")
						.toClassMap());
				
				// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
						.classMap(ProductDTO.class, Product.class)
						.field("id", "id")
						.field("description", "description")
						.field("detail", "detail")
						.field("price", "price")
						.field("stock", "stock")
						.field("brand", "brand")
						.field("model", "model")
						.toClassMap());
		
		
		
		// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
						.classMap(Family.class, FamilyDTO.class)
						//.field("id", "id")
						.field("name", "name")
						.field("abbreviation", "abbreviation")
						.toClassMap());
				
				// register class maps, Mappers, ObjectFactories, and Converters
		mapperFactory.registerClassMap(mapperFactory
						.classMap(FamilyDTO.class, Family.class)
						//.field("id", "id")
						.field("name", "name")
						.field("abbreviation", "abbreviation")
						.toClassMap());
	}
	
	

	@Override
	public void configureFactoryBuilder(DefaultMapperFactory.Builder builder) {
		// configure properties of the factory, if needed
	}
	
	

}
