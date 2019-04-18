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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long user_id;

	  @NotBlank private String user_name;
	  
	   private int registered_to_sale;
	  
	  @NotBlank private String registered_timestamp;
	  
	  @NotBlank private String address;
	  
	  @NotBlank private String mobile;
	  
	  
	  @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
		Set<Purchase> purchase = new HashSet<Purchase>();


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getRegistered_to_sale() {
		return registered_to_sale;
	}


	public void setRegistered_to_sale(int registered_to_sale) {
		this.registered_to_sale = registered_to_sale;
	}


	public String getRegistered_timestamp() {
		return registered_timestamp;
	}


	public void setRegistered_timestamp(String registered_timestamp) {
		this.registered_timestamp = registered_timestamp;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", registered_to_sale=" + registered_to_sale
				+ ", registered_timestamp=" + registered_timestamp + ", address=" + address + ", mobile=" + mobile
				+ ", purchase=" + purchase + "]";
	}
	  
	  
	  
}
