//package com.Itma.model;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@EnableAutoConfiguration 
//@Configuration
//
//public class HibernateSearchClassImplementation extends HibernateSearchClass {
//
//	@Autowired
//    private EntityManager bentityManager;
//	
//	
//	public HibernateSearchClassImplementation(EntityManager entityManager) {
//		super(entityManager);
//		
//	}
//
//	
//
//    @Bean
//    @Primary
//    HibernateSearchClass hibernateSearchService() {
//        HibernateSearchClass hibernateSearchService = new HibernateSearchClass(bentityManager);
//        hibernateSearchService.initializeHibernateSearch();
//        return hibernateSearchService;
//    }
//	
//	
//}
