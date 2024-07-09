package com.te.employee1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.employee1.entity.Employee;

public class EmployeeRepoImplement implements EmployeeRepository {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	@Override
	public void addEmployee() {
		Employee employee = new Employee();
		employee.setEmp_name("vijju");
		employee.setEmp_age(24);
		employee.setEmp_dept("Marketing");
		openConnection();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

	}

	public void fetchEmployee(int emp_id) {
		openConnection();
		Employee employee = entityManager.find(Employee.class, emp_id);
		System.out.println(employee);

	}

	public void updateEmployee(Employee employee, Integer emp_id) {
		openConnection();
		Employee employee1 = entityManager.find(Employee.class, emp_id);
		if (employee.getEmp_age() != null) {
			employee1.setEmp_age(employee.getEmp_age());
		}
		if (employee.getEmp_dept() != null) {
			employee1.setEmp_dept(employee.getEmp_dept());
		}
		if (employee.getEmp_name() != null) {
			employee1.setEmp_name(employee.getEmp_name());
		}
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee1);
		entityTransaction.commit();

	}

	public void deleteEmployee(Integer emp_id) {
		openConnection();
		Employee employee2 = entityManager.find(Employee.class, emp_id);
		if (employee2 != null) {
			entityTransaction.begin();
			entityManager.remove(employee2);
			entityTransaction.commit();
		}
	}

	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee_management");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

}
