package com.pramati.flashsale.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.dao.ProductDao;
import com.pramati.flashsale.dao.PurchaseDao;
import com.pramati.flashsale.dao.UserDao;
import com.pramati.flashsale.model.Product;
import com.pramati.flashsale.model.Purchase;
import com.pramati.flashsale.model.User;

import io.swagger.annotations.ApiModel;

@RestController
@RequestMapping(value="/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "Purchase details API's",description="Api calls related to purchases")
public class PurchaseController {
	
	@Autowired
	private PurchaseDao purchaseDao;
	private ProductDao productDao;
	private UserDao userDao;
	
	@RequestMapping(value="/createPurchase",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createPurchase(@RequestBody  @Valid Purchase p) {
		
		
		Product product = productDao.getProductById(p.getProduct_id());
		User user  = userDao.getUserById(p.getUser_id());
		
		if(product!=null&& product.getAvailabity_count()>0&&product.getFlash_sale_eligibility().equals("yes")&&user.getRegistered_to_sale()==1) {
			
			purchaseDao.createPurchase(p);	
			
		}
		else {
			return "You Cannot Buy this product. Please try again later";
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/updatePurchase",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Purchase updatePurchase(@RequestBody  @Valid Purchase p) {
		return purchaseDao.updatePurchase(p);
	}
	
	
	@RequestMapping(value="/getAllPurchases",method=RequestMethod.GET)
	public List<Purchase> getAllPurchases(){
		
		return purchaseDao.getAllPurchases();
	}
	
	
	@RequestMapping(value="/getPurchaseById/{id}",method=RequestMethod.GET)
	public Purchase getPurchaseById(@PathVariable("id") long id) {
		return purchaseDao.getPurchaseByID(id);
			
	}
	

}
