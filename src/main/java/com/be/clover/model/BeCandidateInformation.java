package com.be.clover.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="be_candidate_information")
@Data
public class BeCandidateInformation {
	
	@Id
	@Column(name="candidate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="candidate_experience_id")
	private List<BeCandidateExperience> candidateExperience;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="candidate_education_id")
	private List<BeCandidateEducation> candidateEducation;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="country")
	private String country;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="resume")
	private String resume;
	
	@Column(name="website")
	private String website;
	
}
