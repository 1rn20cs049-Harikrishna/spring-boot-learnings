package com.effigo.learningportal.dto;

import java.math.BigInteger;
import java.util.Date;

import com.effigo.learningportal.model.Roles;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private Roles role;

	private String name;

	private String email;

	private BigInteger phoneNumber;

	private boolean status;

	private Date createdAt;

	private Date updatedAt;
}
