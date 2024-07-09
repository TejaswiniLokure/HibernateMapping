package com.te.student.dao;

public interface StudentRepository {
	void addStudent();
	void fetchStudent();
	void updateStudent(Integer stuId, String newName, String newCourse, String newCity, int newHomeNo);
	void deleteStudent(Integer stuId);
	
	

}
