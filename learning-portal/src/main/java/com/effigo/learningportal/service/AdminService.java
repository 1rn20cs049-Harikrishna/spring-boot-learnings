package com.effigo.learningportal.service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.User;

public interface AdminService {
	public User createUser(UserDTO userDTO);

	public String adminHome();

}
