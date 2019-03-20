package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.EmployeeDO;
import com.employee.service.EmployeeServices;

@RestController
@RequestMapping(value = "/employeeController")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;

	@RequestMapping(value = "/saveEmployee",method = RequestMethod.POST)
	// CRUD " Create - Post, Read - Get, Update - Put, Delete - Delete
	public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId(employeeVO.getEmployeeId());
		employeeDO.setFirstName(employeeVO.getFirstName());
		employeeDO.setLastName(employeeVO.getLastName());
		employeeDO.setAddress(employeeVO.getAddress());
		employeeDO.setActiveIndicator(employeeVO.getActiveIndicator());
		employeeDO.setLastUpdatedUserId(employeeVO.getLastUpdatedUserId());
		employeeDO.setLastUpdatedTmstmp(employeeVO.getLastUpdatedTmstmp());
		employeeServices.saveEmployee(employeeDO);
		return employeeVO;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public void deleteEmployee(String employeeId) {
		System.out.println("delete");
		employeeServices.deleteEmployee(employeeId);
	}
 
	@RequestMapping(value = "/deleteEmployee2", method = RequestMethod.POST)
	public void deleteEmployeeRecord(String firstName) {
		System.out.println("dele2");
		employeeServices.deleteEmployeeRecordName(firstName);
	}

	@RequestMapping(value = "/findEmployees", method = RequestMethod.GET)
	// @ResponseBody
	public List<EmployeeVO> findEmployees() {
		System.out.println("sysos");
		List<EmployeeDO> employees = employeeServices.findEmployees();
		List<EmployeeVO> employeeVOList = new ArrayList<EmployeeVO>();
		for (EmployeeDO employeeDO : employees) {
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmployeeId(employeeDO.getEmployeeId());
			employeeVO.setFirstName(employeeDO.getFirstName());
			employeeVO.setLastName(employeeDO.getLastName());
			employeeVO.setAddress(employeeDO.getAddress());
			employeeVO.setActiveIndicator(employeeDO.getActiveIndicator());
			employeeVO.setLastUpdatedUserId(employeeDO.getLastUpdatedUserId());
			employeeVO.setLastUpdatedTmstmp(employeeDO.getLastUpdatedTmstmp());
			employeeVOList.add(employeeVO);
		} 
		return employeeVOList;
	}
	

	@RequestMapping(value = "/loadEmployee", method = RequestMethod.POST)
	// @ResponseBody
	public EmployeeVO loadEmployee(String employeeId) {
		EmployeeDO employeeDO = employeeServices.loadEmployee(employeeId);
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmployeeId(employeeDO.getEmployeeId());
		employeeVO.setFirstName(employeeDO.getFirstName());
		employeeVO.setFirstName(employeeDO.getLastName());
		employeeVO.setAddress(employeeDO.getAddress());
		employeeVO.setActiveIndicator(employeeDO.getActiveIndicator());
		employeeVO.setLastUpdatedUserId(employeeDO.getLastUpdatedUserId());
		employeeVO.setLastUpdatedTmstmp(employeeDO.getLastUpdatedTmstmp());
		return employeeVO;
	}
}
