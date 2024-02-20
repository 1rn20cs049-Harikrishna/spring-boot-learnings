package com.effigo.learningportal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.mapper.UserMapper;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.RolesRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	private UserRepository userRepository;
	private RolesRepository rolesRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		UserEntity userEntity = userRepository.save(UserMapper.INSTANCE.toEntity(userDTO));
		userEntity.setUpdatedAt(new Date());
		userEntity.setCreatedAt(new Date());
		return UserMapper.INSTANCE.toDto(userEntity);
	}

	@Override
	public UserDTO searchUserDetails(Long uid) {

		Optional<UserEntity> userOptional = userRepository.findById(uid);
		UserEntity userEntity = userOptional.orElse(null);

		if (userOptional.isPresent()) {
			return UserMapper.INSTANCE.toDto(userEntity);
		}
		return null;
	}

	@Override
	public String adminHome() {

		return null;
	}

	@Override
	public List<UserDTO> getUsers() {

		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
	}

	@Override
	public void deleteUsers() {

		try {
			userRepository.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUserById(Long uid) {

	}

}
