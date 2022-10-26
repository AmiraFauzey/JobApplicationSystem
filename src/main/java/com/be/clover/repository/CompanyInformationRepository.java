package com.be.clover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeCompanyInformation;

@Repository
public interface CompanyInformationRepository extends JpaRepository<BeCompanyInformation, Integer>{
	
	@Query("select u from BeCompanyInformation u where u.companyId = :companyId")
	public BeCompanyInformation findBycompanyId(@Param("companyId") Integer companyId);
	
	@Query("select u from BeCompanyInformation u")
	public List<BeCompanyInformation> getAllCompanyInfo();
}
