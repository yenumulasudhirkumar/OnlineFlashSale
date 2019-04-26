package com.pramati.flashsale.beans;

import javax.validation.constraints.NotNull;

import com.pramati.flashsale.model.RegisteredUserDO;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.model.UserDO;

import lombok.Data;

@Data
public class RegisteredUser {

	@NotNull
	private Integer serialNo;
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private Integer saleId;
	
	
	
	public RegisteredUserDO toRegisteredUSerDO() {
		
		RegisteredUserDO rudo = new RegisteredUserDO();

		SaleDO saleDO = new SaleDO();
		saleDO.setSaleId(this.saleId);
		
		UserDO userDO = new UserDO();
		userDO.setUserId(this.userId);
		
		rudo.setSale(saleDO);
		rudo.setUser(userDO);
		
		return rudo;
	}
	
	
}
