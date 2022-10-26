package com.be.clover.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="be_candidate_experience")
@Data
public class BeCandidateExperience {

	@Id
	@Column(name="candidate_experience_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateExperienceId;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="start_month")
	private Month startMonth;
	
	@Column(name="start_year")
	private Integer startYear;
	
	@Column(name="end_month")
	private Month endMonth;
	
	@Column(name="end_year")
	private Integer endYear;
	
	@Column(name="current_employment_status")
	private String currentEmploymentStatus;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="skills")
	private String skills;
}
