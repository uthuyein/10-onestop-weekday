package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.input.SearchEmployeeDto;
import com.jdc.mkt.model.output.SelectEmployeeDto;
import com.jdc.mkt.model.repo.EmployeeRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Transactional
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}

	@Transactional
	public Employee updateEmployee(int id, Employee e) {
		var opt = repo.findById(id);
		var emp = opt.orElseThrow();
		emp.setName(e.getName());
		emp.setDob(e.getDob());
		emp.setDepartment(e.getDepartment());
		emp.setActive(e.getActive());

		return repo.save(emp);
	}

	@Transactional
	public void deleteEmployee(int id) {
		var opt = repo.findById(id);
		var emp = opt.orElseThrow(() -> new NullPointerException("There is no enitity for that id "));
		repo.delete(emp);
	}

	public List<Employee> searchAll() {
		return repo.findAll();
	}

	public List<SelectEmployeeDto> search(SearchEmployeeDto search) {
		if (null == search) {
			search = new SearchEmployeeDto(null, null, null, null, null);			
		}
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder, CriteriaQuery<SelectEmployeeDto>> searchFun(SearchEmployeeDto search) {
		Function<CriteriaBuilder, CriteriaQuery<SelectEmployeeDto>> fun = cb -> {
			var cq = cb.createQuery(SelectEmployeeDto.class);
			var root = cq.from(Employee.class);

			SelectEmployeeDto.select(cq, root);

			cq.where(search.search(cb, cq, root));

			return cq;
		};
		return fun;
	}
}
