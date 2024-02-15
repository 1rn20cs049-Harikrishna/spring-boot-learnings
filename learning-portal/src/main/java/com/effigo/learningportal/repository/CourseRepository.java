package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
