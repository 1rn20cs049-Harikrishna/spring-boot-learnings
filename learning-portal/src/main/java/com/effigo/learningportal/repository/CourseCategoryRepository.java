package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.model.CourseCategory;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long> {
}
