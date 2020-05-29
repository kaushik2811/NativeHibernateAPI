package com.springBootAPI.project.service;

import java.util.List;

import com.springBootAPI.project.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void saveEmployee(Employee employee);
	public void deleteById(int id);
}
