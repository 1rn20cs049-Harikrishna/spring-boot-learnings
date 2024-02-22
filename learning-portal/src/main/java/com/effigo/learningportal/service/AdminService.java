package com.effigo.learningportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.effigo.learningportal.dto.UserDTO;

public interface AdminService {

	public ResponseEntity<?> searchUserDetails(Long uid);

	public List<UserDTO> getUsers();

	/* public void deleteUsers(); */

	public String adminHome();

	public ResponseEntity<?> createUser(UserDTO userDTO, Long adminId);

	public ResponseEntity<?> deleteUserById(Long aid, Long uid);

}
