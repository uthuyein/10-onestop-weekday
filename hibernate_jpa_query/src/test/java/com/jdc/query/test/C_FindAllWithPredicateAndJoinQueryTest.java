package com.jdc.query.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.model.entity.Department_;
import com.jdc.query.model.entity.Employee;
import com.jdc.query.model.entity.Employee_;

public class C_FindAllWithPredicateAndJoinQueryTest extends JpaEmfFactory{

	@ParameterizedTest
	@CsvSource({"IT"})
	void findWithNativeTest(String keyword) {
		var query = em.createNativeQuery("""
				select * from employee_tbl e
				join department_tbl d on e.dep_id = d.department_id
				where d.depName = 'IT'
				""",Employee.class);
		//query.setParameter(1, keyword);
		System.out.println(query.getResultList());
	}
	
	@ParameterizedTest
	@CsvSource({"IT"})
	void findWithJpqlTest(String keyword) {
		var query = em.createQuery(
				"select e from Employee e where e.department.name = :name",Employee.class);
		query.setParameter("name", keyword);
		System.out.println(query.getResultList());
	}
	
	@ParameterizedTest
	@CsvSource({"IT"})
	void findWithCriteriaTest(String keyword) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Employee.class);
		
		var root = cq.from(Employee.class);
		cq.select(root);
		
		var predicate = cb.equal(root.get(Employee_.department).get(Department_.name), keyword);
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		System.out.println(query.getResultList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
