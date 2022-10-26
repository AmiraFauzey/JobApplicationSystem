package com.be.clover.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.be.clover.model.BeJobInformation;
import com.be.clover.model.JobInformationPage;
import com.be.clover.model.JobInformationSearchCriteria;

@Repository
public class JobInformationCriteriaRepository {
	
	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;
	
	public JobInformationCriteriaRepository(EntityManager entityManager) {

		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}
	
	public Page<BeJobInformation> findAllWithFilters(JobInformationPage jobInformationPage, 
			JobInformationSearchCriteria jobInfoSearchCriteria){
		CriteriaQuery<BeJobInformation> criteriaQuery = criteriaBuilder.createQuery(BeJobInformation.class);
		Root<BeJobInformation> jobInformationRoot = criteriaQuery.from(BeJobInformation.class);
		Predicate predicate = getPredicate(jobInfoSearchCriteria,jobInformationRoot);
		criteriaQuery.where(predicate);
		setOrder(jobInformationPage,criteriaQuery,jobInformationRoot);
		
		TypedQuery<BeJobInformation> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(jobInformationPage.getPageNumber() * jobInformationPage.getPageSize());
		typedQuery.setMaxResults(jobInformationPage.getPageSize());
		
		Pageable pageable = getPageable(jobInformationPage);
		long jobCount = getJobCount(predicate);
		return new PageImpl<>(typedQuery.getResultList(),pageable,jobCount);
	}

	private Predicate getPredicate(JobInformationSearchCriteria jobInfoSearchCriteria,
			Root<BeJobInformation> jobInformationRoot) {
		// TODO Auto-generated method stub
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(jobInfoSearchCriteria.getCompanyName())) {
			predicates.add(
					criteriaBuilder.like(jobInformationRoot.get("companyName"), 
							"%" + jobInfoSearchCriteria.getCompanyName() + "%"));
		}
		if(Objects.nonNull(jobInfoSearchCriteria.getJobTitle())) {
			predicates.add(
					criteriaBuilder.like(jobInformationRoot.get("jobTitle"), 
							"%" + jobInfoSearchCriteria.getJobTitle() + "%"));
		}
		if(Objects.nonNull(jobInfoSearchCriteria.getJobLocation())) {
			predicates.add(
					criteriaBuilder.like(jobInformationRoot.get("jobLocation"), 
							"%" + jobInfoSearchCriteria.getJobLocation() + "%"));
		}
		if(Objects.nonNull(jobInfoSearchCriteria.getJobType())) {
			predicates.add(
					criteriaBuilder.like(jobInformationRoot.get("jobType"), 
							"%" + jobInfoSearchCriteria.getJobType() + "%"));
		}
		if(Objects.nonNull(jobInfoSearchCriteria.getJobRemote())) {
			predicates.add(
					criteriaBuilder.like(jobInformationRoot.get("jobRemote"), 
							"%" + jobInfoSearchCriteria.getJobRemote() + "%"));
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	
	private void setOrder(JobInformationPage jobInformationPage, 
			CriteriaQuery<BeJobInformation> criteriaQuery,
			Root<BeJobInformation> jobInformationRoot) {
		// TODO Auto-generated method stub
		if(jobInformationPage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(criteriaBuilder.asc(jobInformationRoot.get(jobInformationPage.getSortBy())));
		}else {
			criteriaQuery.orderBy(criteriaBuilder.desc(jobInformationRoot.get(jobInformationPage.getSortBy())));
		}
	}
	
	private Pageable getPageable(JobInformationPage jobInformationPage) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(jobInformationPage.getSortDirection(),jobInformationPage.getSortBy());
		return PageRequest.of(jobInformationPage.getPageNumber(), jobInformationPage.getPageSize(),sort);
	}
	
	private long getJobCount(Predicate predicate) {
		// TODO Auto-generated method stub
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<BeJobInformation> countRoot = countQuery.from(BeJobInformation.class);
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return entityManager.createQuery(countQuery).getSingleResult();
	}
}
