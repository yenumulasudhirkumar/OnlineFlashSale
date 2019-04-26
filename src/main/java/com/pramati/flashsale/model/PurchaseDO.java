package com.pramati.flashsale.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pramati.flashsale.beans.Purchase;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 * Purchase class holds information regarding every purchase in the site
 *
 */
@Entity
@Table(name="purchase")
@Getter
@Setter
public class PurchaseDO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2983943653705390175L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer purchaseId;
	
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "productId", insertable = false, updatable = false)
	private ProductDO product;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId", insertable = false, updatable = false)
	private UserDO user;

	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SALE_ID", referencedColumnName = "saleId", insertable = false, updatable = false)
	private SaleDO sale;

	
	
	
	
	/**
	 * constructs and initiates purchase order details
	 * 
	 * @param purchaseId
	 * @param productId
	 * @param userId
	 * @param saleId
	 */
	public PurchaseDO(Integer purchaseId, ProductDO product, UserDO user, SaleDO sale) {
		super();
		this.purchaseId = purchaseId;
		this.product = product;
		this.user = user;
		this.sale = sale;
	}





	public PurchaseDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Purchase toPurchaseDto() {
		
		Purchase purchase = new Purchase();
		
		purchase.setProductId(this.product.getProductId());
		purchase.setUserId(this.user.getUserId());
		purchase.setSaleId(this.sale.getSaleId());
		purchase.setPurchaseId(this.purchaseId);
		
		return purchase;
		
	}
	
	
}
