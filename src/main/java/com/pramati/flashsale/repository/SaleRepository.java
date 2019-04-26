package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pramati.flashsale.model.SaleDO;

public interface SaleRepository extends JpaRepository<SaleDO, Integer> {
	

}
