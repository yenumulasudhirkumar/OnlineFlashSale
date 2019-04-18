package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
