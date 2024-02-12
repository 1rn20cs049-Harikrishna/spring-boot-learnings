package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
