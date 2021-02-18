package com.Itma.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.lucene.search.Query;

@Service
public class HibernateSearchClass {

	@Autowired
	private final EntityManager centityManager;
	
	@Autowired
	public HibernateSearchClass(EntityManager entityManager) {
		super();
		this.centityManager = entityManager;
		
	}
	
	
	public void initializeHibernateSearch() {
		
		try {
			
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);;
			
			fullTextEntityManager.createIndexer().startAndWait();
			
			
		}catch(InterruptedException ex) {
			
			ex.printStackTrace();
			
		}
		
	  }
		
	
	@Transactional
	  public List<Doctor> fuzzySearch(String searchTerm){
			
		 FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
	     QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Doctor.class).get();
	       
	     Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("firstName","lastName", "country","district","doctorEmail","state").matching(searchTerm).createQuery();

	     
	     javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Doctor.class);	
		
	     List<Doctor> doctorList = null;
	     
	     try {
	    	 
	    	 doctorList = jpaQuery.getResultList();
	    	 
	     }catch(NoResultException ex) {
	    	 
	    	   ex.printStackTrace();
	     }
	     
		 return doctorList;
			
		}
		
		
		
	}
	
	

