package com.barclays.cloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.cloud.demo.model.Employee;
import com.barclays.cloud.demo.service.EmployeeService;

@RestController
public class EmployeeController {

//	EmployeeService empService = new EmployeeService();

	@Autowired
	EmployeeService empService;

	// http://localhost:9999/get-emp-by-id/{eid}

//	@GetMapping("/get-emp-by-id/{eid}")
//	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET)
//	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET, produces = { "application/json" })
	public Employee getEmpById(@PathVariable(name = "eid") int employeeId) {
		System.out.println(employeeId);
		return empService.getEmployeeById();
	}

//	http://localhost:9999/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

//	http://localhost:9999/add-emp 

//	@PostMapping("/add-emp")
	@RequestMapping(value = "/add-emp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmp(@RequestBody Employee employee) {
		System.out.println(employee.toString());
		return employee;
	}

}
