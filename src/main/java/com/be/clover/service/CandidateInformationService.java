package com.be.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeCandidateInformation;
import com.be.clover.repository.CandidateInformationRepository;

@Service
public class CandidateInformationService {
	
	@Autowired
	CandidateInformationRepository candidateInformationDao;
	
	public BeCandidateInformation findByCandidateId(Integer candidateId) {
		return candidateInformationDao.findByCandidateId(candidateId);
	}
	
	public BeCandidateInformation createProfile(BeCandidateInformation candidateInformation) {

		return candidateInformationDao.save(candidateInformation);
	}
	
	public BeCandidateInformation updateProfile(BeCandidateInformation candidateInformation){
		if(!(findByCandidateId(candidateInformation.getCandidateId())).equals(null)) {
			candidateInformationDao.save(candidateInformation);
			return findByCandidateId(candidateInformation.getCandidateId());
		}else {
			throw new ResourceNotFoundException("Not found candidate with id = " + candidateInformation.getCandidateId());
		}
	}
	
	public Integer deleteProfile(Integer candidateId) {
		if(findByCandidateId(candidateId).equals(null)) {
			throw new ResourceNotFoundException("Not found candidate with id = " + candidateId);
		}
		candidateInformationDao.deleteById(candidateId);
		return candidateId;
	}
}
