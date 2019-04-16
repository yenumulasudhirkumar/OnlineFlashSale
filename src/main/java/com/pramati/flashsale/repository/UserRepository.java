package com.pramati.flashsale.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

		
}
