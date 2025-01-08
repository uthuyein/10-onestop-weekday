package com.jdc.query.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.model.entity.Department_;
import com.jdc.query.model.entity.Employee;
import com.jdc.query.model.entity.Employee_;
import com.jdc.query.model.entity.dto.SelectEmployee;

public class E_ProjectionWithPredicateQueryTest extends JpaEmfFactory{

	@Order(2)
	@ParameterizedTest
	@CsvSource("Sales")
	void findByDepNameWithCriteria(String name) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectEmployee.class);
		
		var root = cq.from(Employee.class);
		var join = root.join(Employee_.department);
		
		cq.multiselect(
				root.get(Employee_.name),
				root.get(Employee_.dob),
				join.get(Department_.name)
				);
		
		var predicate = cb.equal(join.get(Department_.name), name);
		cq.where(predicate);
		
		var query = em.createQuery(cq);
		System.out.println("Emp list :"+query.getResultList());
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Sales")
	void findByDepNameWithJpql(String name) {
		
		var query = em.createQuery(
				"""
				select new com.jdc.query.model.entity.dto.EmployeeDto(
				e.name,e.dob,e.department.name) from Employee e
				where e.department.name = :name
				""",SelectEmployee.class);
		query.setParameter("name", name);
		
		System.out.println("Emp list :"+query.getResultList());
	}
}
