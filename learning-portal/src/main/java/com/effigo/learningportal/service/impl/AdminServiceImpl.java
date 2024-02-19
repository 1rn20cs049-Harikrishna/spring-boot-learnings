package com.effigo.learningportal.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.mapper.UserPopulator;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserDTO userDTO) {
		UserEntity user = UserPopulator.INSTANCE.populateUser(userDTO);
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		return userRepository.save(user);
	}

	@Override
	public String adminHome() {

		return null;
	}

}
