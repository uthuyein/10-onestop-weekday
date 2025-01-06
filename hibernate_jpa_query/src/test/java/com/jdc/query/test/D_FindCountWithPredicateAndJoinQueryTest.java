package com.jdc.query.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.model.entity.Department;
import com.jdc.query.model.entity.Department_;
import com.jdc.query.model.entity.Employee;
import com.jdc.query.model.entity.Employee_;

public class D_FindCountWithPredicateAndJoinQueryTest extends JpaEmfFactory{
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("s")
	void findDepByEmpNameLikeTest(String name) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Long.class);
		
		var root = cq.from(Department.class);
		cq.select(cb.countDistinct(root.get(Department_.id)));
		
		var join = root.join(Department_.employees);
		
		var predicate = cb.like(cb.lower(join.get(Employee_.name)), name.toLowerCase().concat("%"));
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		System.out.println("Department count  :"+query.getSingleResult());
	}

	@Order(1)
	@ParameterizedTest
	@CsvSource("IT")
	void findEmployeeCountByDepNameTest(String name) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Long.class);
		
		var root = cq.from(Employee.class);
		cq.select(cb.count(root.get(Employee_.id)));
		
		var predicate = cb.equal(root.get(Employee_.department).get(Department_.name), name);
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		System.out.println("Total Emp :"+query.getSingleResult());
	}
}
