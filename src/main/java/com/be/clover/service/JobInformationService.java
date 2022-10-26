package com.be.clover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.JobCreateException;
import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeJobInformation;
import com.be.clover.model.JobInformationPage;
import com.be.clover.model.JobInformationSearchCriteria;
import com.be.clover.repository.JobInformationCriteriaRepository;
import com.be.clover.repository.JobInformationRepository;

@Service
public class JobInformationService {

	@Autowired
	JobInformationRepository jobInformationDao;

	@Autowired
	JobInformationCriteriaRepository jobInformationCriteriaDao;

	public BeJobInformation findByJobId(Integer jobId) {
		return jobInformationDao.findByJobId(jobId);
	}

	public BeJobInformation createJob(BeJobInformation jobInformation) {

		return jobInformationDao.save(jobInformation);
	}

	public BeJobInformation updateJob(BeJobInformation jobInformation) {
		if (!(findByJobId(jobInformation.getJobId())).equals(null)) {
			jobInformationDao.save(jobInformation);
			return findByJobId(jobInformation.getJobId());
		} else {
			throw new ResourceNotFoundException("Not found job with id = " + jobInformation.getJobId());
		}
	}

	public Integer deleteJob(Integer jobId) {
		if (findByJobId(jobId).equals(null)) {
			throw new ResourceNotFoundException("Not found job with id = " + jobId);
		}
		jobInformationDao.deleteById(jobId);
		return jobId;
	}

	public List<BeJobInformation> getAllJobInfo() {
		// TODO Auto-generated method stub
		return jobInformationDao.getAllJobs();
	}

	public Page<BeJobInformation> getJobs(JobInformationPage jobInformationPage, 
			JobInformationSearchCriteria jobInfoSearchCriteria) {
		return jobInformationCriteriaDao.findAllWithFilters(jobInformationPage, jobInfoSearchCriteria);
	}
}
