package com.pramati.flashsale.dao;

import java.util.List;

import com.pramati.flashsale.model.Product;

public interface ProductDao {
	
	public Product createProduct(Product p);
	
	public Product updateProduct(Product p);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(long id);

}
 