package com.jdc.query.test.execise;

import org.junit.jupiter.api.Test;

import com.jdc.query.model.entity.Department;
import com.jdc.query.test.JpaEmfFactory;

public class DepartmentTest extends JpaEmfFactory{

	@Test
	void findAllWithCriteriaQuery() {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Department.class);
		
		var root = cq.from(Department.class);
		cq.select(root);
		var query = em.createQuery(cq);
		System.out.println("Criteria Query :"+query.getResultList());
		
	}
}
