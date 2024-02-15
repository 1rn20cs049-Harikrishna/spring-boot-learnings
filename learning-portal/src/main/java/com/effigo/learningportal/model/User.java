package com.effigo.learningportal.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles role;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(name = "phone_number", nullable = false)
	private BigInteger phoneNumber;

	@Column(nullable = false)
	private boolean status = true;

	@Column(nullable = false)
	private String password;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@PrePersist
	private void DateCreation() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

}
