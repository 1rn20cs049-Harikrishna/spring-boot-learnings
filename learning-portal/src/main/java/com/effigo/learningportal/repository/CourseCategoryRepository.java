package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.CourseCategoryEntity;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategoryEntity, Long> {
}
