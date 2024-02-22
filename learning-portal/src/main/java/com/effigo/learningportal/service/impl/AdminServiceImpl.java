package com.effigo.learningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.mapper.UserMapper;
import com.effigo.learningportal.model.RolesEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.RolesRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AdminService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

	private UserRepository userRepository;
	private RolesRepository rolesRepository;

	@Override
	public ResponseEntity<?> createUser(UserDTO userDTO, Long adminId) {
		try {
			Optional<UserEntity> userEntityCheck = userRepository.findById(adminId);

			if (userEntityCheck.isPresent()) {
				UserEntity isUserAdmin = userEntityCheck.get();
				/*
				 * Optional<RolesEntity> adminRoleOptional = rolesRepository.findById((long) 1);
				 * 
				 * if(!adminRoleOptional.isPresent()) {
				 * ResponseEntity.status(HttpStatus.BAD_REQUEST).
				 * body("Don't know whether user is normal user or admin"); } RolesEntity
				 * rolesEntity = adminRoleOptional.orElse(null);
				 */

				if (isUserAdmin.getRole() != null && isUserAdmin.getRole().getId().equals((long) 1)) {

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

						RolesEntity rolesEntity1 = new RolesEntity();
						rolesEntity1.setId((long) 3);
						rolesEntity1.setName("LEARNER");
						rolesRepository.save(rolesEntity1);

						userEntity.setRole(rolesEntity1);

					}

					return ResponseEntity.status(HttpStatus.CREATED)
							.body(UserMapper.INSTANCE.toDto(userRepository.save(userEntity)));
				}

				else {
					return ResponseEntity.status(HttpStatus.FORBIDDEN)
							.body("User is not an admin,user is not authorised to create to another user");
				}
			}

			else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN)
						.body("User is not an admin,user is not authorised to create to another user");
			}
		} catch (

		Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> searchUserDetails(Long uid) {

		try {
			Optional<UserEntity> userOptional = userRepository.findById(uid);
			UserEntity userEntity = userOptional.orElse(null);

			if (userOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(UserMapper.INSTANCE.toDto(userEntity));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such User found");
			}

		} catch (Exception e) {
			log.info("AdminServiceImpl::searchUserDetails " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@Override
	public String adminHome() {

		return "all okay!! This is admin home page";
	}

	@Override
	public List<UserDTO> getUsers() {

		try {
			List<UserEntity> users = userRepository.findAll();
			return users.stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.info("AdminServiceImpl::getUsers " + e.getMessage());
			throw new RuntimeException("Something went wrong " + e.getMessage());

		}
	}

	/*
	 * @Override public void deleteUsers() {
	 * 
	 * try { userRepository.deleteAll(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	

	@Override
	public ResponseEntity<?> deleteUserById(Long adminId, Long userId) {
		/* Check if the user and admin with the given IDs exists */
		try {

			Optional<UserEntity> userOptional = userRepository.findById(userId);
			Optional<UserEntity> adminOptional = userRepository.findById(adminId);

			if (userOptional.isPresent() && adminOptional.isPresent()) {

				Optional<RolesEntity> adminRoleOptional = rolesRepository.findById((long) 1);

				if (!adminRoleOptional.isPresent()) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User or admin is not present");
				} else {
					if (!adminOptional.get().getRole().getId().equals(adminRoleOptional.get().getId())) {
						return ResponseEntity.status(HttpStatus.FORBIDDEN).body("provide proper admin id");
					}
					userRepository.deleteById(userId);
					return ResponseEntity.status(HttpStatus.NO_CONTENT)
							.body("User with following details are deleted " + userOptional.get());
				}

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such user found");
			}
		} catch (Exception e) {
			log.info("AdminServiceImpl::deleteUserById " + e.getMessage());
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
