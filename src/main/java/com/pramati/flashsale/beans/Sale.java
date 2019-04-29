package com.pramati.flashsale.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author sudhirk
 *
 *  DTO class for the entity sale 
 */
@Data
public class Sale {

	

	@NotNull
	private Integer saleId;
	
	@NotBlank private String saleName;
	
	@NotEmpty private String saleStartTime;
	
	@NotEmpty private String saleEndTime;
	
	
	
	
}
