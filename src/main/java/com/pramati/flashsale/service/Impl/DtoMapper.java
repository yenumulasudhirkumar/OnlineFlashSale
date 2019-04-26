package com.pramati.flashsale.service.Impl;

import java.util.Optional;

import com.pramati.flashsale.beans.Product;
import com.pramati.flashsale.beans.Sale;
import com.pramati.flashsale.beans.User;
import com.pramati.flashsale.model.ProductDO;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.model.UserDO;

public class DtoMapper {


	public static User fromUserDO(UserDO userDO) {


		Optional<UserDO> checkUserDO = Optional.ofNullable(userDO);

		if(!checkUserDO.isPresent()) 
			return null;

		User user = new User();
		user.setAddress(userDO.getAddress());
		user.setUserId(userDO.getUserId());
		user.setUserName(userDO.getUserName());

		return user;
	}



	public static UserDO fromUserDto(User user) {

		Optional<User> checkUserDto = Optional.ofNullable(user);

		if(!checkUserDto.isPresent()) {
			return null;
		}

		UserDO userDO = new UserDO();
		userDO.setUserId(user.getUserId());
		userDO.setUserName(user.getUserName());
		userDO.setAddress(user.getAddress());
		if(user.getMobile()!=null)
			userDO.setMobile(user.getMobile());


		return userDO;

	}


	public static Sale fromSaleDO(SaleDO saleDo) {


		Optional<SaleDO> checkSaleDO = Optional.ofNullable(saleDo);

		if(!checkSaleDO.isPresent()) 
			return null;

		Sale sale = new Sale();
		sale.setSaleId(saleDo.getSaleId());
		sale.setSaleName(saleDo.getSaleName());
		sale.setSaleStartTime(saleDo.getSaleStartTime());
		sale.setSaleEndTime(saleDo.getSaleEndTime());
		return sale;


	}

	public static SaleDO fromSaleDto(Sale sale) {

		Optional<Sale> checkSaleDto = Optional.ofNullable(sale);

		if(!checkSaleDto.isPresent()) {
			return null;
		}

		SaleDO saleDO = new SaleDO();

		saleDO.setSaleStartTime(sale.getSaleStartTime());
		saleDO.setSaleEndTime(sale.getSaleEndTime());
		saleDO.setSaleName(sale.getSaleName());


		if(sale.getSaleId()!=null) {	
			saleDO.setSaleId(sale.getSaleId()); 
		}

		return saleDO;

	}
	
	
	
	public static ProductDO fromProductDto(Product product) {
		
		if(product==null)
			return null;
		
		ProductDO  productDO =new ProductDO();
		
		productDO.setAvailabityCount(product.getAvailabilityCount());
		productDO.setCost(product.getCost());
		//productDO.setProductId(product.getProductId());
		productDO.setProductName(product.getProductName());
		SaleDO saleDO = new SaleDO();
		saleDO.setSaleId(product.getSaleId());
		productDO.setSale(saleDO);
	
		return productDO;
	}
	
	
	public static Product fromProductDO(ProductDO productDO) {
		
		if(productDO==null) {
			return null;
		}
		
		Product product = new Product();
		product.setAvailabilityCount(productDO.getAvailabityCount());
		product.setCost(productDO.getCost());
		product.setProductId(productDO.getProductId());
		product.setProductName(productDO.getProductName());
		product.setSaleId(productDO.getSale().getSaleId());
		
		return product;
		
		
	}

}
