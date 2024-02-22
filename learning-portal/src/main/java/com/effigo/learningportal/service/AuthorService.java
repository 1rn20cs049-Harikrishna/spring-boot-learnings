package com.effigo.learningportal.service;

import java.util.List;

import com.effigo.learningportal.dto.CourseDTO;

public interface AuthorService {
	public CourseDTO createCourse(CourseDTO courseDto, Long authorId);

	public void deleteCourse(Long courseId, Long authorId);

	public CourseDTO editCourse(CourseDTO courseDto, Long authorId);

	public List<CourseDTO> getCourses(Long authorId);
}
