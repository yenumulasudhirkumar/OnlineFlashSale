package com.pramati.flashsale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long purchase_id;
	
	private long product_id;
	
	private long user_id;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "product_id", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "user_id", insertable = false, updatable = false)
	private User user;


	public void setPurchase_id(long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	
	
	
	
}
