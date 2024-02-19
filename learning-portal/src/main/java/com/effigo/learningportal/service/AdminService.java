package com.effigo.learningportal.service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.UserEntity;

public interface AdminService {
	public UserEntity createUser(UserDTO userDTO);

	public String adminHome();

}
