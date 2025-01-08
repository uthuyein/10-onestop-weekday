package com.jdc.mkt.model.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
