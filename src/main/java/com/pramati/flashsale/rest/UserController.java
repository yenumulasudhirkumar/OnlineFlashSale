package com.pramati.flashsale.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.beans.Response;
import com.pramati.flashsale.beans.User;
import com.pramati.flashsale.service.UserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


/**
 * @author sudhirk
 *
 *  Rest Controller which contains api calls related to User Data
 *  
 *
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiModel(value = "User details API's", description = "Contains CRUD API's for user details")
public class UserController {
	
	  private @Autowired UserService userService;
	  
	  
	  @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation("Creates a new user")
	  public ResponseEntity<Response> createUser(@RequestBody  @Valid User user) {
		 
		  Response response = new Response(null, null, userService.createUser(user));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		  
	  }
	  
	  
	  @GetMapping
	  @ApiOperation("Get All Users details")
	  public ResponseEntity<Response> getAllUsers() {
		  
	  
		  Response response = new Response(null, null, userService.GetAllUsers());
		 return new ResponseEntity<Response>(response,HttpStatus.OK);

	  }

	  
	  @GetMapping(value = "/{userId}")
	  @ApiOperation("Get User Details By ID")
	  public ResponseEntity<Response> getUserById(@PathVariable("userId") Integer userId) {
		  
			  Response response = new Response(null, null, userService.getUserById(userId));
			  return new ResponseEntity<Response>(response,HttpStatus.OK);
	  }
	  
	  
	  @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ApiOperation("Updates User Information for a given User ID")
	  public ResponseEntity<Response> updateUser(@RequestBody @Valid User user) {
		  
		  
		  Response response = new Response(null, null, userService.updateUser(user));
		  return new ResponseEntity<Response>(response,HttpStatus.OK);
		  
	  }
	  
	
	
	/*
	 * @PutMapping(value = "/{userId}/saleRegistration/{saleId}")
	 * 
	 * @ApiOperation("Register user for a flash sale") public User
	 * registerForSale(@PathVariable("userId") Integer
	 * userId,@PathVariable("saleId") Integer saleId) {
	 * 
	 * User registeredUser = userService.registerUserForSale(userId,saleId);
	 * 
	 * Response response = new Response(null, null,
	 * userService.getUserById(userId)); return new
	 * ResponseEntity<Response>(response,HttpStatus.OK);
	 * 
	 * }
	 */
	 
	  
}
