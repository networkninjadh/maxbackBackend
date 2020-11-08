package com.maxback.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "sessions")
public class Session {
	@Id
	@GeneratedValue
	private Long sessionId;
	
	private Long employeeId;
	
	private Long customerId;
	
	private String openTokSessionId;
}
