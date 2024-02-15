package com.effigo.learningportal.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.effigo.learningportal.model.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private Roles role;

	private String name;

	private String email;

	private BigInteger phoneNumber;

	private boolean status;

	private String password;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
