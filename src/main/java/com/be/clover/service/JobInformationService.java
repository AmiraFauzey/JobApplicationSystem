package com.be.clover.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.ControllerAdvisor;
import com.be.clover.exceptionHandler.JobCreateException;
import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeJobInformation;
import com.be.clover.model.JobInformationPage;
import com.be.clover.repository.JobInformationCriteriaRepository;
import com.be.clover.repository.JobInformationQueryFactory;
import com.be.clover.repository.JobInformationRepository;

@Service
public class JobInformationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobInformationService.class);
	
	@Autowired
	JobInformationRepository jobInformationDao;
	
	@Autowired
	JobInformationQueryFactory jobInfoQf;

	public BeJobInformation findByJobId(Integer jobId) {
		BeJobInformation result =  jobInformationDao.findByJobId(jobId);
		LOGGER.error("Before Check Job Id");
		LOGGER.error("Result: {}", result);
		if(result == null) {
			LOGGER.error("After Check Job Id");
			throw new ResourceNotFoundException("Not found job with id = " + jobId);
		}
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

	
	public List<BeJobInformation> findAll(Integer pageSize, Integer pageNumber) {
		Pageable firstPageWithTwoElements = PageRequest.of(pageNumber, pageSize);
		Page<BeJobInformation> allProducts = jobInformationDao.findAll(firstPageWithTwoElements);
		LOGGER.error("{}", allProducts.toList());
		return allProducts.toList();
	}
	
	public List<BeJobInformation> searchByPagination(BeJobInformation jobInformation){
		List<BeJobInformation> result = jobInfoQf.searchJobInformation(jobInformation);
		return result;
	}
	 
}
