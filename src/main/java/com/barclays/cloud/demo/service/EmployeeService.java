package com.barclays.cloud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.cloud.demo.exception.EmployeeNotFoundException;
import com.barclays.cloud.demo.model.Employee;
import com.barclays.cloud.demo.repository.EmployeeRepository;

// Exception handling here in this class 

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		if (empOptional.isPresent())
			return empOptional.get();
		String errorMessage = "Employee with eid" + employeeId + " not found.";
		throw new EmployeeNotFoundException(errorMessage);
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> empList = empRepository.findByFirstName(firstName);
		if (!empList.isEmpty())
			return empList;
		String errorMessage = "Employee with name" + firstName + " not found.";
		throw new EmployeeNotFoundException(errorMessage);

	}

	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}

}
