package com.pramati.flashsale.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.flashsale.beans.RegisteredUser;
import com.pramati.flashsale.beans.Response;
import com.pramati.flashsale.service.RegisteredUserService;

import io.swagger.annotations.ApiModel;

/**
 * @author sudhirk
 *
 *  Rest Controller which contains api calls related to User Data
 *  
 *
 */
@RestController
@ApiModel(value = "Sale Registered User's details API's", description = "Contains CRUD API's for Registered for sale user details")
@RequestMapping(value="/registeredUser",produces=MediaType.APPLICATION_JSON_VALUE)
public class RegisteredUserController {
	
	
	@Autowired
	private RegisteredUserService registeredUserService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createRegisteredUser(@RequestBody @Valid RegisteredUser registeredUser){
		
		Response response = new Response("","",registeredUserService.createRegsiterUser(registeredUser));
		
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}
	
	
	
	

}
