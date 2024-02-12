package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
