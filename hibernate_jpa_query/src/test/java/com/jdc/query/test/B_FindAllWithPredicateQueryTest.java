package com.jdc.query.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.model.entity.Employee;
import com.jdc.query.model.entity.Employee_;

public class B_FindAllWithPredicateQueryTest extends JpaEmfFactory{

	@Order(1)
	@ParameterizedTest
	@CsvSource("s")
	void findWithNativeQueryTest(String name) {
		var query = em.createNativeQuery("select * from employee_tbl where lower(name) like ?",Employee.class);
		query.setParameter(1, name.toLowerCase().concat("%"));
		System.out.println(query.getResultList());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("s")
	void findWithJpqlQueryTest(String name) {
		var query = em.createQuery("select e from Employee e where lower(name) like :name",Employee.class);
		query.setParameter("name",  name.toLowerCase().concat("%"));
		System.out.println(query.getResultList());
		
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("s")
	void findWithCriteriaQueryTest(String name) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Employee.class);
		
		//from Employee e
		var root = cq.from(Employee.class);
		
		// select e from Employee e
		cq.select(root);
		
		//  lower(name) like :name
		var predicate = cb.like(cb.lower(root.get(Employee_.name)), name.toLowerCase().concat("%"));
		
		// where lower(name) like :name
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		System.out.println(query.getResultList());
	}
	
	
	
	
	
	
	
	
	
}
