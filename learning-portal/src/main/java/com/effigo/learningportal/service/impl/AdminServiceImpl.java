package com.effigo.learningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.mapper.UserMapper;
import com.effigo.learningportal.model.RolesEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.RolesRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
//@Slf4j
public class AdminServiceImpl implements AdminService {

	private UserRepository userRepository;
	private RolesRepository rolesRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		try {
			UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDTO);
			Optional<RolesEntity> learnerRoleOptional = rolesRepository.findById((long) 3);
			if (learnerRoleOptional.isPresent()) {
				userEntity.setRole(learnerRoleOptional.get());
			} else {

				/*
				 * generally it is not needed , roles already defined in rolesentity to increase
				 * reliability if in case by miss admin delete the roles automatically can bean
				 * created here
				 */

				RolesEntity rolesEntity = new RolesEntity();
				rolesEntity.setId((long) 3);
				rolesEntity.setName("LEARNER");
				rolesRepository.save(rolesEntity);

				userEntity.setRole(rolesEntity);

			}

			return UserMapper.INSTANCE.toDto(userRepository.save(userEntity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	public boolean deleteUserById(Long uid) {
		// Check if the user with the given ID exists
		Optional<UserEntity> userOptional = userRepository.findById(uid);

		if (userOptional.isPresent()) {
			// User found, delete it
			UserEntity user = userOptional.get();
			userRepository.delete(user);

			// Return true to indicate successful deletion
			return true;
		} else {
			// User not found, return false
			return false;
		}
	}

}
