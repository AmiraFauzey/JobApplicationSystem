package com.be.clover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeCandidateEducation;

@Repository
public interface CandidateEducationRepository extends JpaRepository<BeCandidateEducation, Integer>{
	
	@Query("select u from BeCandidateEducation u where u.candidateEducationId = :candidateEducationId")
	public BeCandidateEducation findBycandidateEducationId(@Param("candidateEducationId") Integer candidateEducationId);
}
