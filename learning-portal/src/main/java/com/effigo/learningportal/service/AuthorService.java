package com.effigo.learningportal.service;

import java.util.List;
import java.util.Optional;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;

public interface AuthorService {
	public CourseDTO createCourse(CourseDTO courseDto, Long authorId);

	public CourseDTO editCourse(CourseDTO courseDto, Long authorId);

	public void deleteCourse(Long courseId, Optional<Long> authorId);

	public List<CourseDTO> getCourses(Optional<Long> authorId);

	public CourseEntity editCourse(CourseEntity updatedCourse);
}
