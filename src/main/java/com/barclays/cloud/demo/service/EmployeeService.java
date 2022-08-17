package com.barclays.cloud.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.barclays.cloud.demo.model.Employee;

public class EmployeeService {

	public Employee getEmployeeById() {
		Employee emp = new Employee(101, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 90000));
		empList.add(new Employee(102, "Monu", 95000));
		empList.add(new Employee(103, "Tonu", 85000));
		empList.forEach(e -> System.out.println(e.toString()));
		return empList;
	}

}
