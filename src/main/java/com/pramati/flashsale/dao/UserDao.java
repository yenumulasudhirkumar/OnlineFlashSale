package com.pramati.flashsale.dao;

import java.util.List;

import com.pramati.flashsale.model.User;

public interface UserDao {
	
	public User createUser(User u);
	
	public User registerForSale(User u);
	
	public User updateUser();
	
	public boolean checkUserRegistrationStatus();
	
	public List<User> GetAllUsers();
	
	public User getUserById(long uID);

}
