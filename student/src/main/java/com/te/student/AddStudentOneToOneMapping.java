package com.te.student;

import com.te.student.dao.StudentRepositoryImplementation;
import com.te.student.entity.Address;
import com.te.student.entity.Student;

public class AddStudentOneToOneMapping {
		

	 public static void main(String[] args) {
	        StudentRepositoryImplementation repositoryImplementation = new StudentRepositoryImplementation();

	       	        repositoryImplementation.addStudent();
	    }
	}
	
	


