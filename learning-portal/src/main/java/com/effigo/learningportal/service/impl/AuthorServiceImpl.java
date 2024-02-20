package com.effigo.learningportal.service.impl;

import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.mapper.CoursePopulator;
import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	private  CourseRepository courseRepository;
	private UserRepository userRepository;

	public AuthorServiceImpl(CourseRepository courseRepository,UserRepository userRepository) {
		super();
		this.courseRepository = courseRepository;
		this.userRepository = userRepository;
	}

	@Override
	public CourseDTO createCourse(CourseDTO courseDto, Long authorId) {
		CourseEntity course = CoursePopulator.INSTANCE.CourseDtoToEntity(courseDto);
		return CoursePopulator.INSTANCE.CourseEntityToDto(courseRepository.save(course));
	}

	@Override
	public CourseDTO editCourse(CourseDTO courseDto, Long authorId) {
//		return courseRepository.save(course);
		
		/*
		 * course author_id and user id will be checked if same then user is
		 * allowed to modify that course
		 */
		
		return null;
	}
	
	

}
