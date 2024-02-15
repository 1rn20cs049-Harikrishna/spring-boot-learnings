package com.effigo.learningportal.dto;

import java.sql.Date;

import com.effigo.learningportal.model.Course;
import com.effigo.learningportal.model.User;

public class EnrollmentDTO {
	private Long id;

	private User user;

	private Course course;

	private Date createdAt;
}
