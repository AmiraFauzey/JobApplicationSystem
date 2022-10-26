package com.be.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeCandidateEducation;
import com.be.clover.repository.CandidateEducationRepository;

@Service
public class CandidateEducationService {
	
	@Autowired
	CandidateEducationRepository candidateEducationRepository;
	
	public BeCandidateEducation findBycandidateEducationId(Integer candidateEducationId) {
		return candidateEducationRepository.findBycandidateEducationId(candidateEducationId);
	}
	
	public BeCandidateEducation createNewEducation(BeCandidateEducation candidateEducation) {
		return candidateEducationRepository.save(candidateEducation);
	}
	
	public BeCandidateEducation updateEducation(BeCandidateEducation candidateEducation){
		
		if(!(findBycandidateEducationId(candidateEducation.getCandidateEducationId()).equals(null))) {
			candidateEducationRepository.save(candidateEducation);
			return findBycandidateEducationId(candidateEducation.getCandidateEducationId());
		}else {
			throw new ResourceNotFoundException("Not found experience with id = " + candidateEducation.getCandidateEducationId());
		}
	}
	
	public Integer deleteEducation(Integer candidateEducationId) {
		if(findBycandidateEducationId(candidateEducationId).equals(null)){
			throw new ResourceNotFoundException("Not found experience with id = " + candidateEducationId);
		}
		candidateEducationRepository.deleteById(candidateEducationId);
		return candidateEducationId;
	}
}
