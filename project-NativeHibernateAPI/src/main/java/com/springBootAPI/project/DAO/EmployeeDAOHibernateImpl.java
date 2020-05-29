package com.springBootAPI.project.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBootAPI.project.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theentityManager) {
		entityManager = theentityManager;
	}

	@Override
	public List<Employee> findAll() {

		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		//execute query and get result
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the employee
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//save Employee
		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void deleteById(int id) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		currentSession.delete(employee);

	}

}
