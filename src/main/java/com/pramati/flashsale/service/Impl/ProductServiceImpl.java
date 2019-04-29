package com.pramati.flashsale.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pramati.flashsale.beans.Product;
import com.pramati.flashsale.model.ProductDO;
import com.pramati.flashsale.repository.ProductRepository;
import com.pramati.flashsale.service.ProductService;


/**
 * @author sudhirk
 *
 *  Service Implementation class for Product Service 
 */
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		
		ProductDO productDO = DtoMapper.fromProductDto(product);
		return DtoMapper.fromProductDO(productRepository.save(productDO));
		
	}

	@Override
	public Product updateProduct(Product product) {

		ProductDO productDO = DtoMapper.fromProductDto(product);
		return DtoMapper.fromProductDO(productRepository.save(productDO));
		
	}

	@Override
	public Product getProduct(Integer productId) {

		return DtoMapper.fromProductDO(productRepository.findById(productId).orElse(null));
		
	}
	
}
