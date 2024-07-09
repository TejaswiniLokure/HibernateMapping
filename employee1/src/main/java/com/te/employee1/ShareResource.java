package com.te.employee1;

import com.te.employee1.dao.EmployeeRepoImplement;
import com.te.employee1.entity.Employee;

public class ShareResource {
	public static void main(String[] args) {
		EmployeeRepoImplement employeeRepoImplement=new EmployeeRepoImplement();
//		employeeRepoImplement.addEmployee();
//		employeeRepoImplement.fetchEmployee(1);
//		Employee employee=new Employee().builder().emp_name("raja").emp_dept("IT").emp_age(33).build();
//        employeeRepoImplement.updateEmployee(employee, 1);
//        employeeRepoImplement.fetchEmployee(1);
//        System.out.println(employee);
       employeeRepoImplement.deleteEmployee(13);
	}

}
