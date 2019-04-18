package com.pramati.flashsale.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pramati.flashsale.dao.UserDao;
import com.pramati.flashsale.model.User;
import com.pramati.flashsale.repository.UserRepository;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User u) {
		return userRepository.save(u);
		
	}

	@Override
	public User registerForSale(User u) {
		
		return userRepository.save(u);
		
	}

	@Override
	public User updateUser() {
		return null;
	}

	@Override
	public boolean checkUserRegistrationStatus() {
		return false;
	}

	
	public User getUserById(long uID) {
		
		return userRepository.getOne(uID);
		
	}

	@Override
	public List<User> GetAllUsers() {
		return  userRepository.findAll();
	}

	
	

}
