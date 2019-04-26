package com.pramati.flashsale.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author sudhirk
 *
 * Data Transfer object for User
 */
@Data
public class User implements Serializable{

	
	private static final long serialVersionUID = -7332878451054032887L;

	@NotNull
	private Integer userId;
	
	
	@NotBlank
	private String userName;
	private String mobile;
	@NotBlank
	private String address;
	private Integer saleId;
	
	
}
