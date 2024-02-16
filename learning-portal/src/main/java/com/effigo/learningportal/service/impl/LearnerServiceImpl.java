package com.effigo.learningportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.model.Course;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.LearnerService;

@Service
public class LearnerServiceImpl implements LearnerService {
	private CourseRepository courseRepository;

	private UserRepository userRepository;

	public LearnerServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
		this.courseRepository = courseRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Course> searchCourseById(Long id) {
		
		return null;
	}
	
	@Override
	public List<Course> searchCourseByAuthor(String auhor) {
		
		return null;
	}

	@Override
	public List<Course> searchCourseByCategory(Long id) {
	
		return null;
	}
	
	
	

	@Override
	public String addFavourite(Long uid,Long cid) {

		return null;
	}

	@Override
	public String enrollCourse(Long uid,Long cid) {

		return null;
	}

	

}
