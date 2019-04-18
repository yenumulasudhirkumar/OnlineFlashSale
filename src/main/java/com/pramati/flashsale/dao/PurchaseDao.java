package com.pramati.flashsale.dao;

import java.util.List;

import com.pramati.flashsale.model.Purchase;

public interface PurchaseDao {
	
	public Purchase createPurchase(Purchase p);
	
	public Purchase updatePurchase(Purchase p);
	
	public List<Purchase> getAllPurchases();
	
	public Purchase getPurchaseByID(long id);
	
	
	

}
