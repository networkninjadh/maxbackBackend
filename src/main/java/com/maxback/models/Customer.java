package com.maxback.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "account_start_date")
	private LocalDate accountStartDate = LocalDate.now();
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "address")
	private String address;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private UserFiles userFiles;
	
	//customer posts
	//message boards they've posted on

}