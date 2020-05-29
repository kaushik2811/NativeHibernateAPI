package com.springBootAPI.project.DAO;
import java.util.List;

import com.springBootAPI.project.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public void saveEmployee(Employee employee);
	public void deleteById(int id);
	
}
