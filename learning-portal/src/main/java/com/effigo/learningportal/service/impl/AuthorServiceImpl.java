package com.effigo.learningportal.service.impl;

import org.springframework.stereotype.Service;

import com.effigo.learningportal.model.Course;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {


	private CourseRepository courseRepository;


	public AuthorServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course editCourse(Course course) {
		return courseRepository.save(course);
	}

}
