package com.effigo.learningportal.dto;

import java.sql.Date;

import com.effigo.learningportal.model.CourseCategory;
import com.effigo.learningportal.model.User;

public class CourseDTO {
	private Long id;

	private String name;

	private CourseCategory category;

	private User publisher;

	private Date createdAt;

	private Date updatedAt;

	private boolean status;
}
