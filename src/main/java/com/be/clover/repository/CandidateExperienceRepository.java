package com.be.clover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeCandidateExperience;

@Repository
public interface CandidateExperienceRepository extends JpaRepository<BeCandidateExperience, Integer>{
	
	@Query("select u from BeCandidateExperience u where u.candidateExperienceId = :candidateExperienceId")
	public BeCandidateExperience findBycandidateExperienceId(@Param("candidateExperienceId") Integer candidateExperienceId);
}
