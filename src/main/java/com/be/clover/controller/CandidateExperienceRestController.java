package com.be.clover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.be.clover.exceptionHandler.ControllerAdvisor;
import com.be.clover.model.BeCandidateExperience;
import com.be.clover.service.CandidateExperienceService;

@RestController
@RequestMapping(BeUrlConstant.CANDIDATE_EXPERIENCE)
public class CandidateExperienceRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvisor.class);
	
	@Autowired
	CandidateExperienceService candidateExperienceService;

	// 1.create candidate experience
	@PutMapping(value = BeUrlConstant.EXPERIENCE)
	public ResponseEntity<BeCandidateExperience> createNewExperience(@RequestBody BeCandidateExperience candidateExperience) throws Exception {
		
		BeCandidateExperience saveExperience = candidateExperienceService.createNewExperience(candidateExperience);
		return new ResponseEntity<>(saveExperience, HttpStatus.CREATED);
	}

	// 2.update candidate experience
	@PostMapping(value = BeUrlConstant.EXPERIENCE)
	public ResponseEntity<BeCandidateExperience> updateExp(@RequestBody BeCandidateExperience candidateExperience) throws Exception {

		BeCandidateExperience updateExp = candidateExperienceService.updateExperience(candidateExperience);

		return new ResponseEntity<>(updateExp, HttpStatus.OK);
	}

	// 3.view candidate experience
	@GetMapping(value = BeUrlConstant.EXPERIENCE + "/{candidateExperienceId}")
	public ResponseEntity<BeCandidateExperience> getcandidateExperienceId(@PathVariable Integer candidateExperienceId) {
		BeCandidateExperience result = candidateExperienceService.findBycandidateExperienceId(candidateExperienceId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 4.delete candidate experience
	@DeleteMapping(value = BeUrlConstant.EXPERIENCE)
	public ResponseEntity<Integer> deletecandidateExperience(@RequestParam(value = "candidateExperienceId", required = true) Integer candidateExperienceId) {
		Integer deleteExperience = candidateExperienceService.deleteExeprience(candidateExperienceId);
		return new ResponseEntity<>(deleteExperience, HttpStatus.OK);
	}
}
