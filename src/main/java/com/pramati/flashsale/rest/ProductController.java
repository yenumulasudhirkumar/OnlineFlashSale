package com.pramati.flashsale.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.beans.Product;
import com.pramati.flashsale.beans.Response;
import com.pramati.flashsale.service.ProductService;

import io.swagger.annotations.ApiModel;


@RestController
@RequestMapping(value="/product",produces=MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "Product details API's", description = "Contains CRUD API's for Product details")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	
	@RequestMapping(path="/createProduct",method=RequestMethod.POST ,consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createProduct(@RequestBody @Valid Product product ) {
		
		Response response = new Response(null, null, productService.createProduct(product));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/updateProduct",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateProduct(@RequestBody @Valid Product product) {
		
		Response response = new Response(null, null, productService.updateProduct(product));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/getProductById/{id}",method=RequestMethod.GET)
	public ResponseEntity<Response> getProductById(@PathVariable("id") Integer productId) {

		if(productId!=null) {
			
			Response response = new Response(null, null, productService.getProduct(productId));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		else {
			
			Response response = new Response("Id is Null","Given Product Id is Null","");
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		
	}


}
