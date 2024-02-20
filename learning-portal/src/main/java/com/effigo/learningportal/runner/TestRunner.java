package com.effigo.learningportal.runner;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.RolesEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.RolesRepository;
import com.effigo.learningportal.repository.UserRepository;

@Component
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		UserEntity userEntity = new UserEntity();
//		userEntity.setName("hari");
//		userEntity.setEmail("harikrishna92364@gmail.com");
//		userEntity.setPassword("123456");
//		userEntity.setPhoneNumber(75843);
		
//		userRepository.save(userEntity);
		
		
		
		RolesEntity  rolesEntity = new RolesEntity();
		rolesEntity.setId((long) 1);
		rolesEntity.setName("ADMIN");
		
		
//		rolesEntity.se
		
		RolesEntity rolesEntity2 = new RolesEntity();
		rolesEntity2.setId((long) 2);	
		rolesEntity2.setName("AUTHOR");
		
		RolesEntity rolesEntity3 = new RolesEntity();
		rolesEntity3.setId((long) 3);
		rolesEntity3.setName("LEARNER");
		rolesEntity3.setCreatedAt(new Date());
		
		
		rolesRepository.save(rolesEntity);
		rolesRepository.save(rolesEntity2);
		rolesRepository.save(rolesEntity3);
		
		
		
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setId((long) 1);
		courseEntity.setName("JAVA");
//		courseEntity.setCourseCategory(null);
		courseRepository.save(courseEntity);
		
		
	}

}
