package com.pramati.flashsale.service;

import java.util.List;

import com.pramati.flashsale.beans.User;


public interface UserService {

	
	public User createUser(User u);
	
	
	public User updateUser(User user);
	
	public List<User> GetAllUsers();
	
	public User getUserById(Integer userId);
	
	public User registerUserForSale(Integer userId,Integer saleId);
}
