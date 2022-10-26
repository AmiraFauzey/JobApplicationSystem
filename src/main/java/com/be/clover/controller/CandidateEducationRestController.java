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
import com.be.clover.model.BeCandidateEducation;
import com.be.clover.service.CandidateEducationService;

@RestController
@RequestMapping(value = BeUrlConstant.CANDIDATE_EDUCATION)
public class CandidateEducationRestController {
	
	@Autowired
	CandidateEducationService candidateEduService;
	
	    // 1.create candidate education
		@PutMapping(value = BeUrlConstant.EDUCATION)
		public ResponseEntity<BeCandidateEducation> createEdu(@RequestBody BeCandidateEducation candidateEducation) throws Exception {
			
			BeCandidateEducation saveEducation = candidateEduService.createNewEducation(candidateEducation);
			return new ResponseEntity<>(saveEducation, HttpStatus.CREATED);
		}

		// 2.update candidate education
		@PostMapping(value = BeUrlConstant.EDUCATION)
		public ResponseEntity<BeCandidateEducation> updateEdu(@RequestBody BeCandidateEducation candidateEducation) throws Exception {

			BeCandidateEducation updateEdu = candidateEduService.updateEducation(candidateEducation);

			return new ResponseEntity<>(updateEdu, HttpStatus.OK);
		}

		// 3.view candidate education
		@GetMapping(value = BeUrlConstant.EDUCATION + "/{candidateEducationId}")
		public ResponseEntity<BeCandidateEducation> getEducationById(@PathVariable Integer candidateEducationId) {
			BeCandidateEducation result = candidateEduService.findBycandidateEducationId(candidateEducationId);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}

		// 4.delete candidate education
		@DeleteMapping(value = BeUrlConstant.EDUCATION)
		public ResponseEntity<Integer> deleteEducation(@RequestParam(value = "candidateEducationId", required = true) Integer candidateEducationId) {
			Integer deleteEducation = candidateEduService.deleteEducation(candidateEducationId);
			return new ResponseEntity<>(deleteEducation, HttpStatus.OK);
		}
}
