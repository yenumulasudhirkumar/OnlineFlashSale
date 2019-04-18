package com.pramati.flashsale.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pramati.flashsale.dao.PurchaseDao;
import com.pramati.flashsale.model.Purchase;
import com.pramati.flashsale.repository.PurchaseRepository;

@Repository
public class PurchaseDaoImpl implements PurchaseDao{

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public Purchase createPurchase(Purchase p) {
		
		return purchaseRepository.save(p);
		
	}

	@Override
	public Purchase updatePurchase(Purchase p) {
	
		return purchaseRepository.save(p);
		
	}

	@Override
	public List<Purchase> getAllPurchases() {

		return purchaseRepository.findAll();
		
	}

	@Override
	public Purchase getPurchaseByID(long id) {

		return purchaseRepository.getOne(id);
		
	}
	
	
}
