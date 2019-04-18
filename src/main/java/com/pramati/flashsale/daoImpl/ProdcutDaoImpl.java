package com.pramati.flashsale.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.dao.ProductDao;
import com.pramati.flashsale.model.Product;
import com.pramati.flashsale.repository.ProductRepository;

@Repository
public class ProdcutDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	
	
	
	@Override
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
	
		return productRepository.findAll();
	
	}
	

	@Override
	public Product getProductById(long id) {
		
		return productRepository.getOne(id);
	
	}
	
	

}
