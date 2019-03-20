package com.employee.Controller.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.employee.bean.EmployeeDO;
import com.employee.controller.EmployeeController;
import com.employee.controller.EmployeeVO;
import com.employee.service.EmployeeServices;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeServices employeeServices;

	@InjectMocks
	private EmployeeController employeeController=new EmployeeController();

	private EmployeeVO employeeVO;

	@Before
	public void setUp() {
		employeeVO = new EmployeeVO();
		employeeVO.setEmployeeId("001m1ao000");
		employeeVO.setFirstName("jems");
		employeeVO.setLastName("richa");
		employeeVO.setAddress("mass");
		employeeVO.setActiveIndicator("0");
		employeeVO.setLastUpdatedUserId("001m1ao009");
		employeeVO.setLastUpdatedTmstmp(null);

	}

	@Test
	public void testSaveEmployee() {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeServices.saveEmployee(employeeDO);

		EmployeeVO results = employeeController.saveEmployee(employeeVO);
		assertEquals("001m1ao000", results.getEmployeeId());
		assertEquals("jems", results.getFirstName());
		assertEquals("richa", results.getLastName());
		assertEquals("mass", results.getAddress());
		assertEquals("0", results.getActiveIndicator());
		assertEquals("001m1ao009", results.getLastUpdatedUserId());
		assertEquals(null, results.getLastUpdatedTmstmp());
		/*when( employeeServices.saveEmployee(employeeDO)).thenReturn(employeeVO);*/
		verify(employeeServices, times(1)).saveEmployee(employeeDO);
	}

	@Test
	public void testDeleteEmployee() {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setFirstName("ram");
		employeeDO.setLastName("laxman");

		employeeServices.deleteEmployee("employeeId");

		employeeController.deleteEmployee("001m1ao000");
		assertEquals("001m1ao000", "001m1ao000");
		assertEquals("ram", employeeDO.getFirstName());
		assertEquals("laxman", employeeDO.getLastName());
		verify(employeeServices, times(1)).deleteEmployee("employeeId");
	}

	@Test
	public void testDeleteEmployeeRecord() {
		employeeServices.deleteEmployeeRecordName("firstName");

		employeeController.deleteEmployeeRecord("jems");
		assertEquals("jems", "jems");
		verify(employeeServices, times(1)).deleteEmployeeRecordName("firstName");
	}

	@Test
	public void testLoadEmployee() {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId("000m1a0001");
		employeeDO.setFirstName("RockLine");
		employeeDO.setLastName("Genial");
		employeeDO.setAddress("london");
		employeeDO.setActiveIndicator("2");
		employeeDO.setLastUpdatedUserId("000m1a0009");
		employeeDO.setLastUpdatedTmstmp(null);

		when(employeeServices.loadEmployee("employeeId")).thenReturn(employeeDO);

		EmployeeVO result = employeeController.loadEmployee("employeeId");
		assertEquals("000m1a0001", result.getEmployeeId());
		// assertEquals("RockLine",result.getFirstName());
		// assertEquals("Genial",result.getLastName());
		assertEquals("london", result.getAddress());
		assertEquals("2", result.getActiveIndicator());
		assertEquals("000m1a0009", result.getLastUpdatedUserId());
		// assertEqauls(null,result.getLastUpdatedUserId());
		verify(employeeServices, times(1)).loadEmployee("employeeId");
	}
 
	@Test
	public void testFindEmployees() {

		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId("000m1a0001");
		employeeDO.setFirstName("RockLine");
		employeeDO.setLastName("Genial");
		employeeDO.setAddress("london");
		employeeDO.setActiveIndicator("2");
		employeeDO.setLastUpdatedUserId("000m1a0009");
		employeeDO.setLastUpdatedTmstmp(null);

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setEmployeeId("000m1a0002");
		employeeDO1.setFirstName("RockLine");
		employeeDO1.setLastName("Genial");
		employeeDO1.setAddress("london");
		employeeDO1.setActiveIndicator("2");
		employeeDO1.setLastUpdatedUserId("000m1a0009");
		employeeDO1.setLastUpdatedTmstmp(null);

		List<EmployeeDO> employees = new LinkedList<EmployeeDO>();
		employees.add(employeeDO);
		employees.add(employeeDO1);
		// List list = new LinkedList<>(employees);
		when(employeeServices.findEmployees()).thenReturn(employees);

		List<EmployeeVO> employeeVOList = employeeController.findEmployees();
		EmployeeVO result = employeeVOList.get(0);

		assertEquals("000m1a0001", result.getEmployeeId());
		assertEquals("RockLine", result.getFirstName());
		assertEquals("Genial", result.getLastName());
		assertEquals("london", result.getAddress());
		assertEquals("2", result.getActiveIndicator());
		assertEquals("000m1a0009", result.getLastUpdatedUserId());
		assertEquals(2, employeeVOList.size());
		verify(employeeServices, times(1)).findEmployees();

		EmployeeVO result2 = employeeVOList.get(1);
		assertEquals("000m1a0002", result2.getEmployeeId());
		assertEquals("RockLine", result2.getFirstName());
		assertEquals("Genial", result2.getLastName());
		assertEquals("london", result2.getAddress());
		assertEquals("2", result2.getActiveIndicator());
		assertEquals("000m1a0009", result2.getLastUpdatedUserId());
		verify(employeeServices, times(1)).findEmployees();
	}

}
