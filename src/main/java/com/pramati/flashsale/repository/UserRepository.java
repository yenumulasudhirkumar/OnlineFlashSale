package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.UserDO;

/**
 * @author sudhirk
 *
 *  Interface for User Repository which handles database operations for Users data
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer>{

		
}
