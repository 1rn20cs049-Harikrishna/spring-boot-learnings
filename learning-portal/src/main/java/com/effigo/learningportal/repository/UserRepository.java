package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
