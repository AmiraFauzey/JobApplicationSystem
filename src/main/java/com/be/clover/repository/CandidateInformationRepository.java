package com.be.clover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeCandidateInformation;

@Repository
public interface CandidateInformationRepository extends JpaRepository<BeCandidateInformation, Integer>{
	
	@Query("select u from BeCandidateInformation u where u.candidateId = :candidateId")
	public BeCandidateInformation findByCandidateId(@Param("candidateId") Integer candidateId);
}
