package com.te.student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.student.entity.Address;
import com.te.student.entity.Student;

public class StudentRepositoryImplementation implements StudentRepository {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	@Override
	public void fetchStudent() {

	}

	@Override
	public void deleteStudent(Integer stuId) {
		openConnection();

		Student student = entityManager.find(Student.class, stuId);
		if (student != null) {
			entityTransaction.begin();

			entityManager.remove(student);

			entityTransaction.commit();
		}

		closeConnection();

	}

	@Override
	public void addStudent() {
		Student student1 = new Student();
		student1.setStuName("teja");
		student1.setStuCourse("Devopes");
		Address address = new Address();
		address.setStuCity("london");
		address.setStuHomeNo(16);
		student1.setAddress(address);
		address.setStudent(student1);
		openConnection();
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(address);
		entityTransaction.commit();

	}

	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student_management");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public static void closeConnection() {
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

	@Override
	public void updateStudent(Integer stuId, String newName, String newCourse, String newCity, int newHomeNo) {
		openConnection();

		Student student = entityManager.find(Student.class, stuId);
		entityTransaction.begin();

		student.setStuName(newName);
		student.setStuCourse(newCourse);

		Address address = student.getAddress();
		address.setStuCity(newCity);
		address.setStuHomeNo(newHomeNo);
		address = new Address();
		address.setStuCity(newCity);
		address.setStuHomeNo(newHomeNo);
		student.setAddress(address);
		address.setStudent(student);

		entityManager.merge(student);

		entityTransaction.commit();

		closeConnection();

	}

}
