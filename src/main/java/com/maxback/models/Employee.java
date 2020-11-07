package com.maxback.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
	@Id
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "profile_image")
	private String profileImageUrl;

	@Column(name = "account_start_date")
	private Date accountStartDate = new Date();
	
	@Column(name = "username")
	private String username;
}
