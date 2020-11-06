package com.maxback.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "profiles")
public class Profile {
	@Id
	@Column(name = "profile_id")
	private Long profileId;
	
	@Column(name = "account_start_date")
	private Date accountStartDate = new Date();
	@Column(name = "username")
	private String username;
	
	//current active user session
	
	@OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private UserFiles userFiles;
	
	public void setUserFiles(UserFiles userFiles) {
		if (userFiles == null) {
			if (this.userFiles != null) {
				this.userFiles.setProfile(this);
			} else {
				this.userFiles = userFiles;
			}
		}
	}
}
