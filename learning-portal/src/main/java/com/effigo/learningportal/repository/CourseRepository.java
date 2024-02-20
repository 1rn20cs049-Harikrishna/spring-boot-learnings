package com.effigo.learningportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.effigo.learningportal.model.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

	@Query(value = "SELECT c.* FROM courses c WHERE c.id = :courseId", nativeQuery = true)
	List<CourseEntity> findAllCourseById(@Param("courseId") Long courseId);

//    @Query(value = "SELECT c.name FROM courses c WHERE c.publisher.id = :authorId", nativeQuery = true)
//    Optional<CourseEntity> findAllCourseByAuthorId(@Param("authorId") Long authorId);

}
