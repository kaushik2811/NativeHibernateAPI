package com.springBootAPI.project.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springBootAPI.project.entity.Employee;
import com.springBootAPI.project.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class RestControllerAPI {


	private EmployeeService employeeService;

	@Autowired
	public RestControllerAPI(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> showemployeeList() {
		return employeeService.findAll();	
	}

	@GetMapping("/employees/{id}")
	public Employee showEmployee(@PathVariable int id) {
		Employee employee= employeeService.findById(id);
		if(employee==null) {
			throw new RuntimeException("Employee not found by given ID : "+id);
		}
		return employee;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee employee= employeeService.findById(id);
		if(employee==null) {
			throw new RuntimeException("Employee not found by given ID : "+id);
		}
		employeeService.deleteById(id);
		return "You deleted an employee whose ID is : "+id;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	}

}
