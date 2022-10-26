package com.be.clover.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="be_job_information")
@Data
public class BeJobInformation {
	
	@Id
	@Column(name="job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobId;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="job_salary")
	private String jobSalary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name="job_date")
	private Timestamp jobDate;
	
	@Column(name="job_type")
	private JobType jobType;
	
	@Column(name="job_remote")
	private JobRemote jobRemote;
	
	@Column(name="job_description")
	private String jobDescription;
	
}
