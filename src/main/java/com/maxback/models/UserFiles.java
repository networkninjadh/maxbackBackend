package com.maxback.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_files")
public class UserFiles {
	@Id
	@GeneratedValue
	private Long userFilesId;
	@Column(name = "profile_image_url")
	private String profileImageUrl;
	@Column(name = "reciepts")
	@ElementCollection
	private List<String> recipts = new ArrayList<String>();
	@Column(name = "insurance")
	@ElementCollection
	private List<String> insurance = new ArrayList<String>();
	@Column(name = "license")
	@ElementCollection
	private List<String> license = new ArrayList<String>();
	@Column(name = "other")
	@ElementCollection
	private List<String> other = new ArrayList<String>();
	@Column(name = "w2_forms")
	@ElementCollection
	private List<String> w2Forms = new ArrayList<String>();
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;
	
	
	public void addRecipt(String fileKey) {
		this.recipts.add(fileKey);
	}
	
	public void addInsurance(String fileKey) {
		this.insurance.add(fileKey);
	}
	
	public void addLicense(String fileKey) {
		this.license.add(fileKey);
	}
	
	public void addOther(String fileKey) {
		this.other.add(fileKey);
	}
	
	public void addW2Forms(String fileKey) {
		this.w2Forms.add(fileKey);
	}
	
}