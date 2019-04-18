package com.pramati.flashsale.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.flashsale.daoImpl.UserDaoImpl;
import com.pramati.flashsale.model.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "User details API's", description = "Contains CRUD API's for user details")
public class UserController {
	
	  private @Autowired UserDaoImpl userDaoImpl;
	  
	  @GetMapping("/getAll") 
	  public List<User> getUsers() {
	  
		 List<User> uList = userDaoImpl.GetAllUsers();
		 return uList;

	  }

	  
	  @RequestMapping(path = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation("Creates a new user")
	  public User createUser(@RequestBody  @Valid User u) {
		  
		  User us = userDaoImpl.createUser(u);
		  return us;
		  
	  }
	  
	  @RequestMapping(value = "/registerForSale/{id}", method = RequestMethod.PUT)
	  @ApiOperation("Register user for a flash sale")
	  public User registerForSale(@PathVariable("id") long uId) {
		  
		  User u = userDaoImpl.getUserById(uId);
		  u.setRegistered_to_sale(1);
		  User us  = userDaoImpl.registerForSale(u);
		  return us;
		  
	  }
	  
	  
	  @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	  @ApiOperation("Get User By ID")
	  public User getUserById(@PathVariable("id") long uId) {
		  
		  User u = userDaoImpl.getUserById(uId);
		 
		  return u;
		  
	  }
	
}
