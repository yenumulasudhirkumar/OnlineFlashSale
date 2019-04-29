package com.pramati.flashsale.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.pramati.flashsale.beans.Purchase;
import com.pramati.flashsale.repository.PurchaseRepository;
import com.pramati.flashsale.service.PurchaseService;

/**
 * @author sudhirk
 *
 *Test class to write tests for Purchase Serviice
 *
 */
public class PurchaseTests {
	
	@Mock
	PurchaseRepository purchaseRepository;
	
	@InjectMocks
	PurchaseService purchaseService;
	
	@Test
	public void purchase() {

		Purchase purchase = new Purchase();
		
		purchase.setProductId(100);
		purchase.setPurchaseId(1);
		purchase.setSaleId(1);
		purchase.setUserId(6);
	  
		
		
	  Purchase purchaseResult= purchaseService.createPurchase(purchase);

		assertEquals(6, purchaseResult.getUserId().intValue());
		assertEquals(1, purchaseResult.getSaleId().intValue());
		assertEquals(1, purchaseResult.getPurchaseId().intValue());
		assertEquals(1, purchaseResult.getProductId().intValue());

	}

}
