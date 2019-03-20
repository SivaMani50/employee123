package com.employee.controller;

import java.sql.Timestamp;
import java.util.Date;

public class EmployeeMain {
	public static void main(String[] args) {

		EmployeeController employeeController = new EmployeeController();
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setEmployeeId("112m1ao532");
		employeeVO.setFirstName("srinu");
		employeeVO.setLastName( "raj");
		employeeVO.setAddress("NLR");
		employeeVO.setActiveIndicator("Y");
		employeeVO.setLastUpdatedUserId("srinu");
//		employeeVO.setLastUpdatedTmstmp((Timestamp) new Date());
//		employeeController.saveEmployee(employeeVO);
//		System.out.println(employeeVO);
	}
}
