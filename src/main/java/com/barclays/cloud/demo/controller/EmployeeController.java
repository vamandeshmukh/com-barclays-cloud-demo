package com.barclays.cloud.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.cloud.demo.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/get-emp-by-id")
	public Employee getEmpById() {
		Employee emp = new Employee(101, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

}
