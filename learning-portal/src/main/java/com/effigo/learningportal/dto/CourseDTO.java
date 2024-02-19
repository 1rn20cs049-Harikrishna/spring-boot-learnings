package com.effigo.learningportal.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String name;
    private Long courseCategoryId;
    private Long publisherId;
    private Date createdAt;
    private Date updatedAt;
    private boolean status;

    // Constructors, getters, and setters
}
