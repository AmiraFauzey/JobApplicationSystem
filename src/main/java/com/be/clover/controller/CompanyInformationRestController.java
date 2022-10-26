package com.be.clover.controller;

import java.util.List;

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
import com.be.clover.model.BeCompanyInformation;
import com.be.clover.model.BeJobInformation;
import com.be.clover.service.CompanyInformationService;

@RestController
@RequestMapping(BeUrlConstant.COMPANY_INFORMATION)
public class CompanyInformationRestController {

	@Autowired
	CompanyInformationService companyInfoSvc;

	// 1.create company information
	@PutMapping(value = BeUrlConstant.COMPANY)
	public ResponseEntity<BeCompanyInformation> createCompanyInfo(@RequestBody BeCompanyInformation companyInformation)
			throws Exception {

		BeCompanyInformation saveCompanyInfo = companyInfoSvc.createCompanyInfo(companyInformation);
		return new ResponseEntity<>(saveCompanyInfo, HttpStatus.CREATED);
	}

	// 2.update company information
	@PostMapping(value = BeUrlConstant.COMPANY)
	public ResponseEntity<BeCompanyInformation> updateCompanyInfo(@RequestBody BeCompanyInformation candidateEducation)
			throws Exception {

		BeCompanyInformation updateCompanyInfo = companyInfoSvc.updateCompanyInfo(candidateEducation);

		return new ResponseEntity<>(updateCompanyInfo, HttpStatus.OK);
	}

	// 3.view company information by companyId
	@GetMapping(value = BeUrlConstant.COMPANY + "/{companyId}")
	public ResponseEntity<BeCompanyInformation> getCompanyInfoById(@PathVariable Integer companyId) {
		BeCompanyInformation companyInfoById = companyInfoSvc.findBycompanyId(companyId);
		return new ResponseEntity<>(companyInfoById, HttpStatus.OK);
	}
	
	//View all company Information
	@GetMapping(value = BeUrlConstant.COMPANY)
	public ResponseEntity<List<BeCompanyInformation>> getAlldata() {
		List<BeCompanyInformation> listOfCompanies = companyInfoSvc.getAllCompanyInfo();
		return new ResponseEntity<>(listOfCompanies, HttpStatus.OK);
	}

	// 4.delete Company Info
	@DeleteMapping(value = BeUrlConstant.COMPANY)
	public ResponseEntity<Integer> deleteCompanyInfo(
			@RequestParam(value = "companyId", required = true) Integer companyId) {
		Integer deleteCompanyInfo = companyInfoSvc.deleteCompanyInfo(companyId);
		return new ResponseEntity<>(deleteCompanyInfo, HttpStatus.OK);
	}
}
