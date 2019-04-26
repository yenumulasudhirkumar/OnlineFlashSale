package com.pramati.flashsale.service;

import com.pramati.flashsale.beans.Product;

public interface ProductService {

	public Product createProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product getProduct(Integer productId);
	
	
	
}
