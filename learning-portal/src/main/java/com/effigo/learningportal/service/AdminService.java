package com.effigo.learningportal.service;

import java.util.List;
import java.util.Optional;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.UserEntity;

public interface AdminService {
	public UserDTO createUser(UserDTO userDTO);

	public UserDTO searchUserDetails(Long uid);

	public List<UserDTO> getUsers();

	public void deleteUsers();

	public void deleteUserById(Long uid);

	public String adminHome();

}
