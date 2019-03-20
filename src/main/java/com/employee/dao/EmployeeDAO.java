package com.employee.dao;

import java.util.List;

import com.employee.bean.EmployeeDO;

public interface EmployeeDAO {

	public void saveEmployee(EmployeeDO employeeDO);

	public void updateEmployee(EmployeeDO employeeDO);

	public EmployeeDO getEmployee(String EmployeeId);

	public void deleteEmployee(String EmployeeId);

	public List<EmployeeDO> findEmployees();

	public void deleteEmployee2(String firstName);
}
