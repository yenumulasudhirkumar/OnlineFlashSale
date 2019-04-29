package com.pramati.flashsale.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.flashsale.beans.User;
import com.pramati.flashsale.model.SaleDO;
import com.pramati.flashsale.model.UserDO;
import com.pramati.flashsale.repository.UserRepository;
import com.pramati.flashsale.service.UserService;

/**
 * @author sudhirk
 *
 * Service Implementation class for the entity User
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userRepository;
	
	
	@Override
	public List<User> GetAllUsers() {
		
		return userRepository.findAll()
				.stream()
				.map(DtoMapper::fromUserDO)
				.collect(Collectors.toList());
		
	}
	

	@Override
	public User getUserById(Integer userId) {
		
		return DtoMapper.fromUserDO(userRepository.findById(userId)
				.orElse(null));
	}
	
	
	@Override
	public User createUser(User user) {
		
		UserDO userDO = DtoMapper.fromUserDto(user);
		
		return DtoMapper.fromUserDO(userRepository.save(userDO));
	}
	
	
	@Override
	public User updateUser(User user) {

		return DtoMapper.fromUserDO(userRepository.save(DtoMapper.fromUserDto(user)));
	}

	@Override
	public User registerUserForSale(Integer userId, Integer saleId) {
		
		Optional<UserDO> checkUser = userRepository.findById(userId);
		
		if(!checkUser.isPresent()) {
			return null;
			
		}
		
		UserDO userDO= userRepository.findById(userId).orElse(null);
		SaleDO saleDO = new SaleDO();
		saleDO.setSaleId(saleId);
		return DtoMapper.fromUserDO(userRepository.save(userDO));
		
	}
	

}
