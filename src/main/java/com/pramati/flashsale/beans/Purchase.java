package com.pramati.flashsale.beans;

import javax.validation.constraints.NotNull;

import com.pramati.flashsale.model.ProductDO;
import com.pramati.flashsale.model.PurchaseDO;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.model.UserDO;

import lombok.Data;

@Data
public class Purchase {

	@NotNull
	private Integer purchaseId;
	
	@NotNull
	private Integer saleId;
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private Integer productId;
	
	
	
	public PurchaseDO toPurchaseDO() {
		
		PurchaseDO purchaseDO = new PurchaseDO();
		
		ProductDO productDO = new ProductDO();
		productDO.setProductId(this.productId);
		
		UserDO userDO = new UserDO();
		userDO.setUserId(this.userId);
		
		SaleDO saleDO = new SaleDO();
		saleDO.setSaleId(this.saleId);
		

		purchaseDO.setProduct(productDO);
		purchaseDO.setUser(userDO);
		purchaseDO.setSale(saleDO);
		
		return purchaseDO;
		
	}
	
}
