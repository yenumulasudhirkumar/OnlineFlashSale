package com.pramati.flashsale.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pramati.flashsale.beans.RegisteredUser;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="registered_user")
@Getter
@Setter
public class RegisteredUserDO implements Serializable{

	private static final long serialVersionUID = 63638579721572920L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer serialNo;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SALE_ID", referencedColumnName = "saleId")
	private SaleDO sale;
	

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private UserDO user;
	

	public RegisteredUser toRegisteredUSerDto() {
		
		RegisteredUser rudto = new RegisteredUser();
		rudto.setSerialNo(this.serialNo);
		rudto.setSaleId(sale.getSaleId());
		rudto.setUserId(user.getUserId());
		return rudto;

	}
	

}
