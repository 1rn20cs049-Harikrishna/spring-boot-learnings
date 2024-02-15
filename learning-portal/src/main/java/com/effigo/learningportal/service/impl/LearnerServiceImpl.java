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
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired 
	UserRepository userRepository;
	

	@Override
	public List<Course> searchCourse(Long id) {
		
		return null;
	}

	@Override
	public String addFavourite(Long id) {
		
		return null;
	}

	@Override
	public String enrollCourse(Long id) {
		
		return null;
	}

}
