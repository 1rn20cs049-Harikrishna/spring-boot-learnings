package com.effigo.learningportal.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class FavoriteDTO {

    private Long id;
    private Long userId;
    private Long courseId;
    private Date createdAt;
    private Date updatedAt;

    // Constructors, getters, and setters
}
