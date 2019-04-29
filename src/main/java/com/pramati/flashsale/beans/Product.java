package com.pramati.flashsale.beans;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
	
/**
 * @author sudhirk
 *
 * DTO class for the entity product
 */
@Data
public class Product {
	
	@Id
	private long productId;
	
	@NotNull
	private String productName;
	
	@NotNull
	private Integer cost;
	
	@NotNull
	private Integer availabilityCount;
	
	@NotNull
	private Integer saleId;
	

}
