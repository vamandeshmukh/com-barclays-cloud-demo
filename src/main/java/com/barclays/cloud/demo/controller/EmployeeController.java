package com.barclays.cloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.cloud.demo.model.Employee;
import com.barclays.cloud.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	// http://localhost:9999/emp/get-emp-by-id/{eid}

	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int employeeId) {
		Employee emp = empService.getEmployeeById(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "employee with eid " + employeeId + " returned successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

	// http://localhost:9999/emp/get-all-emps

	@RequestMapping(value = "/get-all-emps", method = RequestMethod.GET, produces = { "application/json" })
	@GetMapping("/get-all-emps")
	public ResponseEntity<List<Employee>> getAllEmps() {
		List<Employee> empList = empService.getAllEmployees();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All employees returned successfully.");
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(empList, headers, status);
		return response;
	}

//	http://localhost:9999/emp/add-emp 

	@RequestMapping(value = "/add-emp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "employee added successfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(empService.addEmployee(employee), headers, status);
		return response;
	}

}

//package com.barclays.cloud.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.barclays.cloud.demo.model.Employee;
//import com.barclays.cloud.demo.service.EmployeeService;
//
//@RestController
//@RequestMapping("/emp")
//public class EmployeeController {
//
////	EmployeeService empService = new EmployeeService();
//
//	@Autowired
//	EmployeeService empService;
//
//	// http://localhost:9999/get-emp-by-id/{eid}
//	// http://localhost:9999/emp/get-emp-by-id/{eid}
//
////	@GetMapping("/get-emp-by-id/{eid}")
////	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET)
////	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/get-emp-by-id/{eid}", method = RequestMethod.GET, produces = { "application/json" })
//	public Employee getEmpById(@PathVariable(name = "eid") int employeeId) {
//		System.out.println(employeeId);
//		return empService.getEmployeeById();
//	}
//
////	http://localhost:9999/get-all-emps
//
//	@GetMapping("/get-all-emps")
//	public List<Employee> getAllEmps() {
//		return empService.getAllEmployees();
//	}
//
////	http://localhost:9999/add-emp 
//
////	@PostMapping("/add-emp")
//	@RequestMapping(value = "/add-emp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Employee addEmp(@RequestBody Employee employee) {
//		System.out.println(employee.toString());
//		return employee;
//	}
//
//}
