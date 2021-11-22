package com.xyz.dal.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8926293275066941494L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "phone", nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", nullable = false)
	private String emailAddress;
}
