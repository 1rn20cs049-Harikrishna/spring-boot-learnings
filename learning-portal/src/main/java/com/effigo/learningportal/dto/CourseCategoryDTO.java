package com.effigo.learningportal.dto;

import java.util.Set;

import com.effigo.learningportal.model.CourseEntity;

import lombok.Data;

@Data
public class CourseCategoryDTO {

	private Long id;

	private String name;

	private Set<CourseEntity> courses;

	private boolean status;
}
