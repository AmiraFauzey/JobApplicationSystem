package com.be.clover.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.be.clover.model.BeJobInformation;

@Repository
public class JobInformationQueryFactory {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<BeJobInformation> searchJobInformation(BeJobInformation params){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BeJobInformation> query = builder.createQuery(BeJobInformation.class);
        Root<BeJobInformation> from = query.from(BeJobInformation.class);
        
        List<Predicate> predicates = generateCriteria(builder, from, params);
        
        query.select(from).distinct(true);
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        TypedQuery<BeJobInformation> tQuery = entityManager.createQuery(query);
        Query queryTotal = entityManager.createQuery
        	    ("Select count(f.id) from BeJobInformation f");
        long countResult = (long)queryTotal.getSingleResult();
        int pageSize = 10;
        int pageNumber = (int) ((countResult / pageSize) + 1);
        tQuery.setFirstResult(pageNumber);
        tQuery.setMaxResults(pageSize);
        return tQuery.getResultList();
	}

	private List<Predicate> generateCriteria(CriteriaBuilder builder, Root<BeJobInformation> from,
			BeJobInformation params) {
		List<Predicate> predicates = new ArrayList<>();
		if(!(params.getJobTitle().equals(null))) {
			predicates.add(builder.equal(from.get("jobTitle"), params.getJobTitle()));
		}
		if(!(params.getCompanyName().equals(null))) {
			predicates.add(builder.equal(from.get("companyName"), params.getJobTitle()));
		}
		if(!(params.getJobLocation().equals(null))) {
			predicates.add(builder.equal(from.get("jobLocation"), params.getJobTitle()));
		}
		if(!(params.getJobSalary().equals(null))) {
			predicates.add(builder.equal(from.get("jobSalary"), params.getJobTitle()));
		}
		if(!(params.getJobDate().equals(null))) {
			predicates.add(builder.equal(from.get("jobDate"), params.getJobTitle()));
		}
		if(!(params.getJobType().equals(null))) {
			predicates.add(builder.equal(from.get("jobType"), params.getJobTitle()));
		}
		if(!(params.getJobRemote().equals(null))) {
			predicates.add(builder.equal(from.get("jobRemote"), params.getJobTitle()));
		}
		if(!(params.getJobDescription().equals(null))) {
			predicates.add(builder.equal(from.get("jobDescription"), params.getJobTitle()));
		}
		return predicates;
	}
}
