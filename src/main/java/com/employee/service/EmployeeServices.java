package com.employee.service;

import java.util.List;

import com.employee.bean.EmployeeDO;

public interface EmployeeServices {

	public   void saveEmployee(EmployeeDO employeeDO);

	public void deleteEmployee(String employeeId);

	public EmployeeDO loadEmployee(String employeeId);

	public List<EmployeeDO> findEmployees();
	
	public void deleteEmployeeRecordName(String firstName);
}
