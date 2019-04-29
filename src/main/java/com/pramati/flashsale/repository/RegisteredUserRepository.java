package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pramati.flashsale.model.RegisteredUserDO;

/**
 * @author sudhirk
 *
 * Interface for RegisteredUserRepository which handles database operations for Registered Users data
 */
public interface RegisteredUserRepository extends JpaRepository<RegisteredUserDO, Integer>{

	
	 
	 
	@Query("SELECT u FROM RegisteredUserDO rud where u.user_id =?1 and t.sale_id=?2")
	RegisteredUserDO findByUserIdAndSaleId(Integer UserId,Integer SaleId);
	
}
