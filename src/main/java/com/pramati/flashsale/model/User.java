package com.pramati.flashsale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	private long id;

	  @NotBlank private String user_name;
	  
	  @NotBlank private boolean registered_to_sale;
	  
	  @NotBlank private String registered_timestamp;
	  
	  @NotBlank private String address;
	  
	  @NotBlank private String mobile;
	  
	  
	  

}
