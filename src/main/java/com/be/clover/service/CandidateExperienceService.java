package com.be.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeCandidateExperience;
import com.be.clover.model.BeJobInformation;
import com.be.clover.repository.CandidateExperienceRepository;

@Service
public class CandidateExperienceService {
	
	@Autowired
	CandidateExperienceRepository candidateExperienceDao;
	
	public BeCandidateExperience findBycandidateExperienceId(Integer candidateExperienceId) {
		return candidateExperienceDao.findBycandidateExperienceId(candidateExperienceId);
	}
	
	public BeCandidateExperience createNewExperience(BeCandidateExperience candidateExperience) {
		return candidateExperienceDao.save(candidateExperience);
	}
	
	public BeCandidateExperience updateExperience(BeCandidateExperience candidateExperience){
		
		if(!(findBycandidateExperienceId(candidateExperience.getCandidateExperienceId()).equals(null))) {
			candidateExperienceDao.save(candidateExperience);
			return findBycandidateExperienceId(candidateExperience.getCandidateExperienceId());
		}else {
			throw new ResourceNotFoundException("Not found experience with id = " + candidateExperience.getCandidateExperienceId());
		}
	}
	
	public Integer deleteExeprience(Integer candidateExperienceId) {
		if(findBycandidateExperienceId(candidateExperienceId).equals(null)) {
			throw new ResourceNotFoundException("Not found experience with id = " + candidateExperienceId);
		}
		candidateExperienceDao.deleteById(candidateExperienceId);
		return candidateExperienceId;
	}

}
