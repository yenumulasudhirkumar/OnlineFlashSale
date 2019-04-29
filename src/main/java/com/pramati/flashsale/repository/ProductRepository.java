package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.ProductDO;

/**
 * @author sudhirk
 *
 * Interface for Product repository which handles database operations
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductDO, Integer>{
	

}
