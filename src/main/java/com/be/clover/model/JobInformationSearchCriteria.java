package com.be.clover.model;

public class JobInformationSearchCriteria {
	
	private String jobTitle;
	private String companyName;
	private String jobLocation;
	private JobType jobType;
	private JobRemote jobRemote;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public JobRemote getJobRemote() {
		return jobRemote;
	}
	public void setJobRemote(JobRemote jobRemote) {
		this.jobRemote = jobRemote;
	}
}
