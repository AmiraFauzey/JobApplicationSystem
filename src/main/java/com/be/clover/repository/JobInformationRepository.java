package com.be.clover.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeJobInformation;

@Repository
public interface JobInformationRepository extends JpaRepository<BeJobInformation, Integer>{
	
	@Query("select u from BeJobInformation u where u.jobId = :jobId")
	public BeJobInformation findByJobId(@Param("jobId") Integer jobId);

	@Query("select u from BeJobInformation u")
	public List<BeJobInformation> getAllJobs();
	
	Page<BeJobInformation> findAll(Pageable pageable);
}
