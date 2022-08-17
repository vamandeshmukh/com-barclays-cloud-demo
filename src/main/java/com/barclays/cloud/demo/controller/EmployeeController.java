package com.barclays.cloud.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.cloud.demo.model.Employee;

@RestController
public class EmployeeController {

//	http://localhost:9999/get-emp-by-id

	@GetMapping("/get-emp-by-id")
	public Employee getEmpById() {
		Employee emp = new Employee(101, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

//	http://localhost:9999/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 90000));
		empList.add(new Employee(102, "Monu", 95000));
		empList.add(new Employee(103, "Tonu", 85000));

		empList.forEach(e -> System.out.println(e.toString()));
		return empList;
	}

}
