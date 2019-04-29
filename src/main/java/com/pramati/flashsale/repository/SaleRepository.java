package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pramati.flashsale.model.SaleDO;

/**
 * @author sudhirk
 * 
 *  Interface for Sale Repository which handles database operations for Sales Data
 *
 */
public interface SaleRepository extends JpaRepository<SaleDO, Integer> {
	

}
