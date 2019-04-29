package com.pramati.flashsale.test;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.pramati.flashsale.beans.RegisteredUser;
import com.pramati.flashsale.beans.User;
import com.pramati.flashsale.repository.RegisteredUserRepository;
import com.pramati.flashsale.service.RegisteredUserService;
import static org.junit.Assert.assertEquals;


/**
 * @author sudhirk
 *
 *Test class to write tests for User Registration Serviice
 *
 */
public class UserRegistrationTest {

	
	@Mock
	RegisteredUserRepository registeredUserRepository;
	
	@InjectMocks
	RegisteredUserService registeredUserService;
	
	
	@Test
	public void registerUser() {

		RegisteredUser	userDTO = new RegisteredUser();
	  userDTO.setUserId(100);
	  userDTO.setSaleId(1);

	  
		
		
	  RegisteredUser flashSaleUserDTO = registeredUserService.createRegsiterUser(userDTO);

		assertEquals(100, flashSaleUserDTO.getUserId().intValue());
		assertEquals(1, flashSaleUserDTO.getSaleId().intValue());

	}


	
}
