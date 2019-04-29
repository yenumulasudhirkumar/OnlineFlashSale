package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.PurchaseDO;

/**
 * @author sudhirk
 *
 * Interface for Purchase Repository which handles database operations 
 */
@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseDO, Long>{

	
}
