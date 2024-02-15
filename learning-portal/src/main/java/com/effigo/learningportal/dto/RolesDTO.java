package com.effigo.learningportal.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RolesDTO {
	private Long id = (long) 1;

	private String name;

	private boolean status;;
}
