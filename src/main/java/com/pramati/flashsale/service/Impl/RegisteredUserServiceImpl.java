package com.pramati.flashsale.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.flashsale.beans.RegisteredUser;
import com.pramati.flashsale.repository.RegisteredUserRepository;
import com.pramati.flashsale.service.RegisteredUserService;
import com.pramati.flashsale.util.ApplicationException;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class RegisteredUserServiceImpl implements RegisteredUserService{

	@Autowired
	private RegisteredUserRepository registeredUserRepository;

	@Override
	public RegisteredUser createRegsiterUser(RegisteredUser registeredUser) {

		if(registeredUser.getSaleId()!=null&registeredUser.getUserId()!=null) {
			
			return registeredUserRepository.save(registeredUser.toRegisteredUSerDO()).toRegisteredUSerDto();
		}
		else {
			throw new ApplicationException("Details of Sale ID and User ID is mandatory");
		}
		
	}
	
	
	
	
	
}
