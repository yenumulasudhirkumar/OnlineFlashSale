package com.pramati.flashsale.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long product_id;
	
	@NotBlank 
	private String product_name;
	
	@NotBlank
	private String flash_sale_eligibility;
	
	private Integer availabity_count;
	
	private Integer cost;
	
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	Set<Purchase> purchase = new HashSet<Purchase>();


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getFlash_sale_eligibility() {
		return flash_sale_eligibility;
	}


	public void setFlash_sale_eligibility(String flash_sale_eligibility) {
		this.flash_sale_eligibility = flash_sale_eligibility;
	}


	public Integer getAvailabity_count() {
		return availabity_count;
	}


	public void setAvailabity_count(Integer availabity_count) {
		this.availabity_count = availabity_count;
	}


	public Integer getCost() {
		return cost;
	}


	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	
}
