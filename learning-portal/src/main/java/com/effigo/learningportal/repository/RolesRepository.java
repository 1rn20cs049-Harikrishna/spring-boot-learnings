package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
