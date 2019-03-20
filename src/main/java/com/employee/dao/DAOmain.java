package com.employee.dao;

import com.employee.bean.EmployeeDO;

public class DAOmain {
	private static EmployeeDO employeeDO;
public static void main(String[] args) {
	System.out.println("Hai");
	 EmployeeDAOImp  employeeDAOImp=new EmployeeDAOImp(null);
	 employeeDAOImp.saveEmployee(employeeDO);
	 System.out.println(employeeDAOImp);
}
}
