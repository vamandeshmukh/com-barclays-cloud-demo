package com.barclays.cloud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.barclays.cloud.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	findById 
//	findAll
//	insert 
//	update 
//	delete

}
