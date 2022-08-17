package com.barclays.cloud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.cloud.demo.model.Employee;
import com.barclays.cloud.demo.repository.EmployeeRepository;

// Exception handling here in this class 

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public Employee getEmployeeById(int employeeId) {
		return empRepository.findById(employeeId).get();
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		return empRepository.findByFirstName(firstName);
	}

	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

}
