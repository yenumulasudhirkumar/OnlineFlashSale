package com.pramati.flashsale.service.Impl;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.flashsale.beans.Product;
import com.pramati.flashsale.beans.Purchase;
import com.pramati.flashsale.beans.RegisteredUser;
import com.pramati.flashsale.model.ProductDO;
import com.pramati.flashsale.model.PurchaseDO;
import com.pramati.flashsale.model.RegisteredUserDO;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.repository.ProductRepository;
import com.pramati.flashsale.repository.PurchaseRepository;
import com.pramati.flashsale.repository.RegisteredUserRepository;
import com.pramati.flashsale.repository.SaleRepository;
import com.pramati.flashsale.service.PurchaseService;
import com.pramati.flashsale.util.ApplicationException;

/**
 * @author sudhirk
 *
 * Service Implementation class for the entity Purchase
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Purchase createPurchase(Purchase purchase) {
		
		
		PurchaseDO purchaseDO = purchase.toPurchaseDO();
		Boolean check = isEligible(purchaseDO);
		
		if(check==true) {
		
			ProductDO productDO = productRepository.getOne(purchaseDO.getProduct().getProductId());
			productDO.setAvailabityCount(productDO.getAvailabityCount()-1);
			productRepository.save(productDO);
			return purchaseRepository.save(purchaseDO).toPurchaseDto();
		}
		else
			throw new ApplicationException("Cannot create Purchase Order");
	}
	
	
	public Boolean isEligible(PurchaseDO purchaseDO) {
		
		LocalDateTime time = LocalDateTime.now();
		RegisteredUserDO registerUser = registeredUserRepository.findByUserIdAndSaleId(purchaseDO.getUser().getUserId(),purchaseDO.getSale().getSaleId());
		if(registerUser!=null) {
			throw new ApplicationException("User doesn't registered for Sale");
		}

		Optional<ProductDO> product = productRepository.findById(purchaseDO.getProduct().getProductId());
		if(!product.isPresent()) {
			throw new ApplicationException("Product is not in Sale");
		}
		
		SaleDO saleDO = saleRepository.findById(purchaseDO.getSale().getSaleId()).get();
		if(time.isBefore(saleDO.getSaleStartTime())) {
			throw new ApplicationException("Product Sale not yet started");
		}
		
		if(time.isAfter(saleDO.getSaleEndTime())) {
			throw new ApplicationException("Product sale is ended");
		}
		
		ProductDO productDO = productRepository.findById(purchaseDO.getProduct().getProductId()).orElse(null);
		
		if(productDO!=null&&productDO.getAvailabityCount()<=0) {
			throw new ApplicationException("Sale is Over .Items are not available");
		}

		 return true;
		
		
	}
	
	
}
