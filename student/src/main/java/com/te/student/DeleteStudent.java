package com.te.student;

import com.te.student.dao.StudentRepositoryImplementation;

public class DeleteStudent {
	public static void main(String[] args) {
		StudentRepositoryImplementation repositoryImplementation = new StudentRepositoryImplementation();
		repositoryImplementation.deleteStudent(3);
	}

}
