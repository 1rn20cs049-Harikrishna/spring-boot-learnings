package com.effigo.learningportal.service;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;

public interface AuthorService {
	public CourseDTO createCourse(CourseDTO courseDto,Long authorId);

	public CourseDTO editCourse(CourseDTO courseDto,Long authorId);
}
