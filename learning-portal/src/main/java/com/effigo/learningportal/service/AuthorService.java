package com.effigo.learningportal.service;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;

public interface AuthorService {
	public CourseEntity createCourse(CourseDTO courseDto,Long authorId);

	public CourseEntity editCourse(CourseEntity course);
}
