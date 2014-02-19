/**
 * 
 */
package com.mopelo.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.mopelo.domain.Customer;
import com.mopelo.domain.Family;
import com.mopelo.domain.OrderRow;
import com.mopelo.domain.Product;
import com.mopelo.domain.User;
import com.mopelo.service.dto.CustomerDTO;
import com.mopelo.service.dto.FamilyDTO;
import com.mopelo.service.dto.OrderRowDTO;
import com.mopelo.service.dto.ProductDTO;
import com.mopelo.service.dto.UserDTO;

/**
 * MopeloMapper
 * 
 * @author cguerrero
 */
public class MopeloMapper extends ConfigurableMapper {

	@Override
	public void configure(MapperFactory mapperFactory) {

		// mapper Product.
		mapperFactory.registerClassMap(mapperFactory
				.classMap(Product.class, ProductDTO.class).field("id", "id")
				.field("description", "description").field("detail", "detail")
				.field("price", "price").field("stock", "stock")
				.field("brand", "brand").field("model", "model").toClassMap());

		// mapper Product.
		mapperFactory.registerClassMap(mapperFactory
				.classMap(ProductDTO.class, Product.class).field("id", "id")
				.field("description", "description").field("detail", "detail")
				.field("price", "price").field("stock", "stock")
				.field("brand", "brand").field("model", "model").toClassMap());

		// mapper Family
		mapperFactory.registerClassMap(mapperFactory
				.classMap(Family.class, FamilyDTO.class).field("id", "id")
				.field("name", "name").field("abbreviation", "abbreviation")
				.toClassMap());

		// mapper Family
		mapperFactory.registerClassMap(mapperFactory
				.classMap(FamilyDTO.class, Family.class).field("id", "id")
				.field("name", "name").field("abbreviation", "abbreviation")
				.toClassMap());

		// mapper user
		mapperFactory.registerClassMap(mapperFactory
				.classMap(User.class, UserDTO.class).field("id", "id")
				.field("login", "login").field("password", "password")
				.field("date", "date").field("lastAccess", "lastAccess")
				.field("userType", "userType").toClassMap());

		// mapper user
		mapperFactory.registerClassMap(mapperFactory
				.classMap(UserDTO.class, User.class).field("id", "id")
				.field("login", "login").field("password", "password")
				.field("date", "date").field("lastAccess", "lastAccess")
				.field("userType", "userType").toClassMap());

		// mapper customer
		mapperFactory.registerClassMap(mapperFactory
				.classMap(Customer.class, CustomerDTO.class).field("id", "id")
				.field("name", "name").field("surname", "surname")
				.field("nif", "nif").field("address", "address")
				.field("postalCode", "postalCode").field("email", "email")
				.field("telephone", "telephone").toClassMap());

		// mapper customer
		mapperFactory.registerClassMap(mapperFactory
				.classMap(CustomerDTO.class, Customer.class).field("id", "id")
				.field("name", "name").field("surname", "surname")
				.field("nif", "nif").field("address", "address")
				.field("postalCode", "postalCode").field("email", "email")
				.field("telephone", "telephone").toClassMap());

		// mapper order
		mapperFactory.registerClassMap(mapperFactory
				.classMap(OrderRow.class, OrderRowDTO.class).field("id", "id")
				.field("number", "number").field("price", "price")
				.field("product", "product").field("order", "order")
				.field("discount", "discount").toClassMap());

		// mapper order
		mapperFactory.registerClassMap(mapperFactory
				.classMap(OrderRowDTO.class, OrderRow.class).field("id", "id")
				.field("number", "number").field("price", "price")
				.field("product", "product").field("order", "order")
				.field("discount", "discount").toClassMap());
	}

	@Override
	public void configureFactoryBuilder(DefaultMapperFactory.Builder builder) {
		// configure properties of the factory, if needed
	}

}
