package com.be.clover.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.be.clover.constant.BeUrlConstant;
import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeJobInformation;
import com.be.clover.model.JobInformationPage;
import com.be.clover.model.JobInformationSearchCriteria;
import com.be.clover.service.JobInformationService;

@RestController
@RequestMapping(BeUrlConstant.JOB_INFORMATION)
public class JobInformationRestController {

	@Autowired
	JobInformationService jobInformationService;

	// insert job into database

	@PutMapping(value = BeUrlConstant.JOB)
	public ResponseEntity<BeJobInformation> createJob(@RequestBody BeJobInformation jobInformation){

		BeJobInformation saveJob = jobInformationService.createJob(jobInformation);
		return new ResponseEntity<>(saveJob, HttpStatus.CREATED);
	}

	@GetMapping(value = (BeUrlConstant.JOB + "/template"))
	public ResponseEntity<BeJobInformation> getTemplate() {
		return new ResponseEntity<>(new BeJobInformation(), HttpStatus.OK);
	}

	// update job
	@PostMapping(value = BeUrlConstant.JOB)
	public ResponseEntity<BeJobInformation> updateJob(@RequestBody BeJobInformation jobInformation){

		BeJobInformation jobInfo = jobInformationService.updateJob(jobInformation);

		return new ResponseEntity<>(jobInfo, HttpStatus.OK);
	}

	// Delete job
	@DeleteMapping(value = BeUrlConstant.JOB)
	public ResponseEntity<Integer> deleteJob(@RequestParam(value = "jobId", required = true) Integer jobId) {
		Integer deleteJob = jobInformationService.deleteJob(jobId);
		return new ResponseEntity<>(deleteJob, HttpStatus.OK);
	}

	// Get all data
	@GetMapping(value = BeUrlConstant.JOB)
	public ResponseEntity<List<BeJobInformation>> getAlldata() {
		List<BeJobInformation> listOfJobs = jobInformationService.getAllJobInfo();
		if(listOfJobs.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listOfJobs, HttpStatus.OK);
	}

	// Get data by jobId
	@GetMapping(value = BeUrlConstant.JOB + "/{jobId}")
	public ResponseEntity<BeJobInformation> getJobById(@PathVariable Integer jobId) {
		if(jobId.equals(null)) {
			throw new ResourceNotFoundException("Not found job with id = " + jobId);
		}
		BeJobInformation result = jobInformationService.findByJobId(jobId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//Get filter data result
	@GetMapping
    public ResponseEntity<Page<BeJobInformation>> getJobs(JobInformationPage jobInformationPage,
    		JobInformationSearchCriteria jobInformationSearchCriteria){
        return new ResponseEntity<>(jobInformationService.getJobs(jobInformationPage, jobInformationSearchCriteria),
                HttpStatus.OK);
    }

}
