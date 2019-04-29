package com.pramati.flashsale.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author sudhirk
 *
 * Data Transfer object for User
 */
@Data
public class User {

	

	@NotNull
	private Integer userId;
	
	
	@NotBlank
	private String userName;
	private String mobile;
	@NotBlank
	private String address;
	private Integer saleId;
	
	
}
