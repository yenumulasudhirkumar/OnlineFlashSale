package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.ProductDO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDO, Integer>{
	

}
