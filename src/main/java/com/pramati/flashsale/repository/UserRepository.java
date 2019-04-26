package com.pramati.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.UserDO;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer>{

		
}
