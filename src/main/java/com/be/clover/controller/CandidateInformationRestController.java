package com.be.clover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.be.clover.model.BeCandidateInformation;
import com.be.clover.model.BeJobInformation;
import com.be.clover.service.CandidateInformationService;

@RestController
@RequestMapping(BeUrlConstant.CANDIDATE_INFORMATION)
public class CandidateInformationRestController {
	
	@Autowired
	CandidateInformationService candidateInformationService;
	
	//1.create info
	@PutMapping(value = BeUrlConstant.CANDIDATE_PROFILE)
	public ResponseEntity<BeCandidateInformation> createProfile(@RequestBody BeCandidateInformation candidateInformation) throws Exception {

		BeCandidateInformation saveProfile = candidateInformationService.createProfile(candidateInformation);
		return new ResponseEntity<>(saveProfile, HttpStatus.CREATED);
	}
	//2.update info
	@PostMapping(value = BeUrlConstant.CANDIDATE_PROFILE)
	public ResponseEntity<BeCandidateInformation> updateProfile(@RequestBody BeCandidateInformation candidateInformation) throws Exception {

		BeCandidateInformation updProfile = candidateInformationService.updateProfile(candidateInformation);

		return new ResponseEntity<>(updProfile, HttpStatus.OK);
	}
	//3.delete info
	@DeleteMapping(value = BeUrlConstant.CANDIDATE_PROFILE)
	public ResponseEntity<Integer> deleteProfile(@RequestParam(value = "candidateId", required = true) Integer candidateId) {
		Integer deleteProfile = candidateInformationService.deleteProfile(candidateId);
		return new ResponseEntity<>(deleteProfile, HttpStatus.OK);
	}
	//4.view candidate by id
	@GetMapping(value = BeUrlConstant.CANDIDATE_PROFILE + "/{candidateId}")
	public ResponseEntity<BeCandidateInformation> getProfileById(@PathVariable Integer candidateId) {
		BeCandidateInformation result = candidateInformationService.findByCandidateId(candidateId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
