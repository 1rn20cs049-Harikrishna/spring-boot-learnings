package com.effigo.learningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseCategoryEntity;
import com.effigo.learningportal.model.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

	@Query(value = "SELECT c.* FROM courses c WHERE c.id = :courseId", nativeQuery = true)
	List<CourseEntity> findAllCourseById(@Param("courseId") Long courseId);

	@Query(value = "SELECT * FROM courses WHERE publisher_id = :publisherId", nativeQuery = true)
	List<CourseEntity> findAllByPublisherId(Long publisherId);

	@Query(value = "SELECT * FROM courses WHERE courseCategory.id = :category.id", nativeQuery = true)
	List<CourseDTO> findByCourseCategory(@Param("category") CourseCategoryEntity category);

}
