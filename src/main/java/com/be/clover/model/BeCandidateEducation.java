package com.be.clover.model;

import java.sql.Date;

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
@Table(name="be_candidate_education")
@Data
public class BeCandidateEducation {
	
	@Id
	@Column(name="candidate_education_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateEducationId;
	
	@Column(name="school")
	private String school;
	
	@Column(name="degree_certificate")
	private String degreeCertificate;
	
	@Column(name="field_of_study")
	private String fieldOfStudy;
	
	@Column(name="location")
	private String location;
	
	@Column(name="start_month")
	private Month startMonth;
	
	@Column(name="start_year")
	private Integer startYear;
	
	@Column(name="end_month")
	private Month endMonth;
	
	@Column(name="end_year")
	private Integer endYear;
	
	@Column(name="current_study_status")
	private String currentStudyStatus;
	
	@Column(name="study_description")
	private String studyDescription;
}
