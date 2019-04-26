package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.PurchaseDO;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseDO, Long>{

}
