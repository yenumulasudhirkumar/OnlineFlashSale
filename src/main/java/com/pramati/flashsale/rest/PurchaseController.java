package com.pramati.flashsale.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.beans.Purchase;
import com.pramati.flashsale.beans.Response;
import com.pramati.flashsale.service.PurchaseService;

import io.swagger.annotations.ApiModel;

@RestController
@RequestMapping(value="/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "Purchase details API's",description="Api calls related to purchases")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	
	@PostMapping(value="/",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createPurchase(@RequestBody @Valid Purchase purchase){
		
		Response response = new Response("","",purchaseService.createPurchase(purchase));
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}
	
	/*
	 * @RequestMapping(value="/createPurchase",method=RequestMethod.POST,consumes=
	 * MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * public String createPurchase(@RequestBody @Valid PurchaseDO p) {
	 * 
	 * 
	 * ProductDO product = productService.getProductById(p.getProductId());
	 * 
	 * if(product!=null&&
	 * product.getAvailabityCount()>0&&product.getFlashSaleEligibility().equals(
	 * "yes")) {
	 * 
	 * purchaseDao.createPurchase(p);
	 * 
	 * } else { return "You Cannot Buy this product. Please try again later"; }
	 * 
	 * return null; }
	 * 
	 * 
	 * @RequestMapping(value="/updatePurchase",method=RequestMethod.PUT,consumes=
	 * MediaType.APPLICATION_JSON_VALUE) public PurchaseDO
	 * updatePurchase(@RequestBody @Valid PurchaseDO p) { return
	 * purchaseDao.updatePurchase(p); }
	 * 
	 * 
	 * @RequestMapping(value="/getAllPurchases",method=RequestMethod.GET) public
	 * List<PurchaseDO> getAllPurchases(){
	 * 
	 * return purchaseDao.getAllPurchases(); }
	 * 
	 * 
	 * @RequestMapping(value="/getPurchaseById/{id}",method=RequestMethod.GET)
	 * public PurchaseDO getPurchaseById(@PathVariable("id") long id) { return
	 * purchaseDao.getPurchaseByID(id);
	 * 
	 * }
	 * 
	 */	

}
