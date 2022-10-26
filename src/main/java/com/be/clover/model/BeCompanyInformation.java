package com.be.clover.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="be_company_information")
@Data
public class BeCompanyInformation {
	
	@Id
	@Column(name="company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	@Column(name="company_size")
	private Integer companySize;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_type")
	private String companyType;
	
	@Column(name="company_sector")
	private String companySector;
	
	@Column(name="company_founded")
	private Integer companyFounded;
	
	@Column(name="company_industry")
	private String companyIndustry;
	
	@Column(name="company_revenue")
	private Integer companyRevenue;
}
