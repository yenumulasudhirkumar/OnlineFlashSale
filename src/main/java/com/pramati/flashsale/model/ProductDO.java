package com.pramati.flashsale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


/**
 * @author sudhirk
 * 
 * Product Bean class which contains all the details regarding a product that is available in a site. 
 *
 */
@Entity
@Table(name="product")
@Getter
@Setter
public class ProductDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5479592513009358087L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	
	@NotBlank 
	private String productName;
	
	
	@Column(columnDefinition=" int default 0")
	private Integer availabityCount;
	
	@Column(columnDefinition=" int default 0")
	private Integer cost;

	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SALE_ID", referencedColumnName = "saleId")
	private SaleDO sale;	


	/**
	 * Constructs and initializes a product.
	 * 
	 * @param productId
	 * @param productName
	 * @param flashSaleEligibility
	 * @param availabityCount
	 * @param cost
	 */
	public ProductDO(Integer productId, @NotBlank String productName,
			Integer availabityCount, Integer cost, SaleDO sale) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.availabityCount = availabityCount;
		this.cost = cost;
		this.sale = sale;
	}	


	public ProductDO() {
	}


	
}
