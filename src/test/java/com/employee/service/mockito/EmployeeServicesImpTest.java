package com.employee.service.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.employee.bean.EmployeeDO;
import com.employee.dao.EmployeeDAO;
import com.employee.service.EmployeeServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServicesImpTest {

	@InjectMocks
	private EmployeeServiceImp employeeServices;

	@Mock
	private EmployeeDAO employeeDAO;

	EmployeeDO employeeDO;

	@Before
	public void setUp() {
		employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId("111m1ao110");
	}

	@Test
	public void testSaveEmployee() {
		when(employeeDAO.getEmployee("111m1ao110")).thenReturn(employeeDO);
		employeeDAO.updateEmployee(employeeDO);
		
		employeeServices.saveEmployee(employeeDO);
		
		verify(employeeDAO, times(1)).getEmployee("111m1ao110");
		verify(employeeDAO, times(2)).updateEmployee(employeeDO);
	}

	@Test
	public void testDeleteEmployee() {
		employeeDAO.deleteEmployee("111m1a0110");

		employeeServices.deleteEmployee("112m1a0518");
		
		verify(employeeDAO, times(1)).deleteEmployee("112m1a0518");
	}
	
	@Test
	public void testLoadEmployee(){
	when(employeeDAO.getEmployee("121m1ao133")).thenReturn(employeeDO);
	
	EmployeeDO result=employeeServices.loadEmployee("121m1ao133");
	
	assertEquals("111m1ao110",result.getEmployeeId());
	verify( employeeDAO,times(1)).getEmployee("121m1ao133");
	}
	
	@Test
	public void testDeleteEmployeeRecordName(){
		employeeDAO.deleteEmployee2("susil");
		
		employeeServices.deleteEmployeeRecordName("shinde");
		
		verify(employeeDAO,times(1)).deleteEmployee2("susil");
	}
	
	@Test
	public void testFindEmployees(){
	List<EmployeeDO> list =	new ArrayList<>();
		
		when(employeeDAO.findEmployees()).thenReturn(list);
	
		
		List<EmployeeDO> listResult=employeeServices.findEmployees();
		
		assertEquals("111m1ao110", employeeDO.getEmployeeId());
		verify(employeeDAO,times(1)).findEmployees();
	}
}
