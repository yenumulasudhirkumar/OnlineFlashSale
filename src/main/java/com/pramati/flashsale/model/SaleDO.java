package com.pramati.flashsale.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 *	This class contains the details regarding Flash Sales in the site
 *
 */
@Entity
@Table(name="sale")
@Getter
@Setter
public class SaleDO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer saleId;
	
	@NotBlank private String saleName;
	
	@NotEmpty private String saleStartTime;
	
	@NotEmpty private String saleEndTime;

	
	
	
	/*
	 * @ManyToMany(mappedBy = "userSale") private Set<UserDO> user = new
	 * HashSet<UserDO>();
	 */
	
	
	public SaleDO() {
		super();
	}

	public SaleDO(Integer saleId, @NotBlank String saleName, @NotEmpty String saleStartTime, @NotEmpty String saleEndTime) {
		super();
		this.saleId = saleId;
		this.saleName = saleName;
		this.saleStartTime = saleStartTime;
		this.saleEndTime = saleEndTime;
	}

	
}
