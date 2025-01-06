package com.jdc.query.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public class JpaEmfFactory {

	public static EntityManagerFactory emf;
	public EntityManager em;
	
	@BeforeAll
	public static void init() {
		emf = Persistence.createEntityManagerFactory("jpa_query");
	}
	
	@BeforeEach
	public void createEm() {
		em = emf.createEntityManager();
	}
	
	@AfterEach
	public void closeEm() {
		if(null != em && em.isOpen())
			em.close();
	}
	
}
