package com.pramati.flashsale.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 * This is a User Bean Class which contains details regarding a user who registers in the site.
 */
@Entity
@Getter
@Setter
@Table(name = "user")
public class UserDO extends AuditingEntity {



	private static final long serialVersionUID = 7641913677188894605L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer userId;

	  @NotBlank private String userName;
	  
	  @NotBlank private String address;
	  
	  @NotBlank private String mobile;

	  

	/*
	 * @ManyToMany(cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable( name = "User_Sale", joinColumns = { @JoinColumn(name = "userId")
	 * }, inverseJoinColumns = { @JoinColumn(name = "saleId") }) Set<SaleDO>
	 * userSale = new HashSet<SaleDO>();
	 */

	  
	  
	
	/**
	 * Constructs and initializes a user with following parameters
	 * 
	 * @param userId
	 * @param userName
	 * @param address
	 * @param mobile
	 */
	public UserDO(Integer userId, @NotBlank String userName, @NotBlank String address, @NotBlank String mobile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.mobile = mobile;
	}


	public UserDO() {
		super();
	}
	

	
}
