package com.pramati.flashsale.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Sale implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -6318154663477301036L;

	@NotNull
	private Integer saleId;
	
	@NotBlank private String saleName;
	
	@NotEmpty private String saleStartTime;
	
	@NotEmpty private String saleEndTime;
	
	
	
	
}
