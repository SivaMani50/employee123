package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.EmployeeDO;
import com.employee.dao.EmployeeDAO;

@Service
public class EmployeeServiceImp implements EmployeeServices {

	@Autowired
	private EmployeeDAO employeeDAO;

	public void saveEmployee(EmployeeDO employee) {
/*		System.out.println("Hello Service");
*/		EmployeeDO employeeDO = employeeDAO.getEmployee(employee.getEmployeeId());
		if (employeeDO == null) {
			employeeDAO.saveEmployee(employee);
		} else {
			employeeDAO.updateEmployee(employee);
		}
	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
	//
	// public void deleteEmployee(String employeeId,String firstName) {
	// employeeDAO.deleteEmployee(employeeId);
	// employeeDAO.deleteEmployee2(firstName);
	// } 
 
	public EmployeeDO loadEmployee(String employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	public List<EmployeeDO> findEmployees() {
		return employeeDAO.findEmployees();
	}

	@Override
	public void deleteEmployeeRecordName(String firstName) {
		employeeDAO.deleteEmployee2(firstName);
	}

}
