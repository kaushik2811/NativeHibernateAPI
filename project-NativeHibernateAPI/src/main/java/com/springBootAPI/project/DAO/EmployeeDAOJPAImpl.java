package com.springBootAPI.project.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springBootAPI.project.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		//create a Query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		//execute Query and get Results
		List<Employee> employeeList = theQuery.getResultList();
		//return employee List
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		//get employee
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		//save or update employee
		Employee theemployee = entityManager.merge(employee);
		//update with id from database.. so we can get generated id for save/insert.
		employee.setId(theemployee.getId());
	}

	@Override
	public void deleteById(int id) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id =: empId");
		theQuery.setParameter("empId", id);
		theQuery.executeUpdate();
	}
	
	
}
