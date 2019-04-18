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
import com.pramati.flashsale.model.Product;

import io.swagger.annotations.ApiModel;


@RestController
@RequestMapping(value="/product",produces=MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "Product details API's", description = "Contains CRUD API's for Product details")
public class ProductController {
	
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(path= "/getAll",method = RequestMethod.GET)
	public List<Product> getAllProducts(){
		
		return productDao.getAllProducts();
		
	}
	
	
	@RequestMapping(path="/createProduct",method=RequestMethod.POST ,consumes= MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody @Valid Product p ) {
		
		return productDao.createProduct(p);
		
	}
	
	
	@RequestMapping(path="/updateProduct",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody @Valid Product p) {
		
		return productDao.updateProduct(p);
		
	}
	
	
	@RequestMapping(value="/getProductById/{id}",method=RequestMethod.GET)
	public Product getProductById(@PathVariable("id") long product_id) {
		
		return productDao.getProductById(product_id);
		
	}


}
