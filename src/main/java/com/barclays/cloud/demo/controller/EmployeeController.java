package com.barclays.cloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.cloud.demo.model.Employee;
import com.barclays.cloud.demo.service.EmployeeService;

@RestController
public class EmployeeController {

//	EmployeeService empService = new EmployeeService();

	@Autowired
	EmployeeService empService;


	//	http://localhost:9999/get-emp-by-id

	@GetMapping("/get-emp-by-id")
	public Employee getEmpById() {
		return empService.getEmployeeById();
	}

//	http://localhost:9999/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

}
