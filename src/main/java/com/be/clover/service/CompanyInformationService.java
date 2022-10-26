package com.be.clover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.clover.exceptionHandler.ResourceNotFoundException;
import com.be.clover.model.BeCompanyInformation;
import com.be.clover.repository.CompanyInformationRepository;

@Service
public class CompanyInformationService {
	
	@Autowired
	CompanyInformationRepository companyInformationDao;
	
	public BeCompanyInformation findBycompanyId(Integer companyId) {
		return companyInformationDao.findBycompanyId(companyId);
	}
	
	public BeCompanyInformation createCompanyInfo(BeCompanyInformation companyInfo) {
		return companyInformationDao.save(companyInfo);
	}
	
	public BeCompanyInformation updateCompanyInfo(BeCompanyInformation companyInfo){
		
		if(!(findBycompanyId(companyInfo.getCompanyId())).equals(null)) {
			companyInformationDao.save(companyInfo);
			return findBycompanyId(companyInfo.getCompanyId());
		}else {
			throw new ResourceNotFoundException("Not found experience with id = " + companyInfo.getCompanyId());
		}
	}
	
	public Integer deleteCompanyInfo(Integer companyId) {
		if(findBycompanyId(companyId).equals(null)){
			throw new ResourceNotFoundException("Not found experience with id = " + companyId);
		}
		companyInformationDao.deleteById(companyId);
		return companyId;
	}
	
	public List<BeCompanyInformation> getAllCompanyInfo() {
		// TODO Auto-generated method stub
		return companyInformationDao.getAllCompanyInfo();
	}

}
