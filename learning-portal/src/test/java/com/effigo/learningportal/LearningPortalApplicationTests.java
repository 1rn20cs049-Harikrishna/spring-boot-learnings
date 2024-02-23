package com.effigo.learningportal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.effigo.learningportal.service.impl.AdminServiceImpl;
import com.effigo.learningportal.service.impl.AuthorServiceImpl;
import com.effigo.learningportal.service.impl.LearnerServiceImpl;

@SpringBootTest
class LearningPortalApplicationTests {

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	private LearnerServiceImpl learnerServiceImpl;

	@Autowired
	private AuthorServiceImpl authorServiceImpl;

	@Test
	void contextLoads() {

		assertNotNull(adminServiceImpl, "The adminServiceImpl bean should not be null");
		assertNotNull(learnerServiceImpl, "The learnerServiceImpl bean should not be null");
		assertNotNull(authorServiceImpl, "The authorServiceImpl bean should not be null");

	}

}
