package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.EnrollmentEntity;
import com.effigo.learningportal.model.UserEntity;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " + "FROM enrollment "
			+ "WHERE user_id = :userId AND course_id = :courseId", nativeQuery = true)
	boolean existsByUserAndCourse(@Param("userId") Long userId, @Param("courseId") Long courseId);

}
