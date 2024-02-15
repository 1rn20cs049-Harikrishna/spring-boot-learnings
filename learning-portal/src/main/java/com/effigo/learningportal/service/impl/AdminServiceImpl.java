package com.effigo.learningportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.model.User;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public String adminHome() {

		return null;
	}

}
