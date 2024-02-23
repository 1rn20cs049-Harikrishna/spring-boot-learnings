package com.effigo.learningportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM users WHERE id = :uid", nativeQuery = true)
	Optional<UserEntity> getUserById(Long uid);

}
