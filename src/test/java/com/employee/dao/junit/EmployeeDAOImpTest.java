package com.employee.dao.junit;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.employee.bean.EmployeeDO;
import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImp;

public class EmployeeDAOImpTest {

	@InjectMocks
	private EmployeeDAO employeeDAO;
	private EmbeddedDatabase db;
	
	@Before
	public void setup() {
		db = (new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/createEmployee.sql").addScript("db/sql/insertEmployee.sql").build());
		JdbcTemplate template = new JdbcTemplate(db);
		employeeDAO = new EmployeeDAOImp(template);
	}
	
	@After
    public void tearDown() {
        db.shutdown();
    } 

 
	@Test 
	public void testSaveEmployee() {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId("20");
		employeeDO.setFirstName("ram");
		employeeDO.setLastName("krish");
		employeeDO.setAddress("Banar");
		employeeDO.setActiveIndicator("1");
		employeeDO.setLastUpdatedUserId("112m1a0510");
		employeeDO.setLastUpdatedTmstmp(new Timestamp(0));
		employeeDAO.saveEmployee(employeeDO);
	}

	@Test
	public void testFindEmployees(){
		
		List<EmployeeDO> employees = employeeDAO.findEmployees();
	assertEquals(employees.isEmpty(), false);
	EmployeeDO employeeDetails = employees.iterator().next();
	
	assertEquals("Kill", employeeDetails.getFirstName());	
	assertEquals("Bill", employeeDetails.getLastName());
	assertEquals("Hyd", employeeDetails.getAddress());
	assertEquals("1", employeeDetails.getActiveIndicator());
	
	
		/*List<EmployeeDO> employeeDO1=employeeDAO.findEmployees();
		for(EmployeeDO employeeD2:employeeDO1){
	
		assertEquals("20",employeeD2.getEmployeeId());
		assertEquals("Kill",employeeD2.getFirstName());
		assertEquals("Bill",employeeD2.getLastName());
		assertEquals("Hyd", employeeD2.getAddress());
		assertEquals("1",employeeD2.getActiveIndicator());
		
		assertEquals("2", employeeD2.getEmployeeId());
        assertEquals("Killer",employeeD2.getFirstName());
        assertEquals("Biller",employeeD2.getLastName());
	}*/
	}
	@Test
	public void testUpdateEmployee() {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId("20");
		employeeDO.setFirstName("Kill");
		employeeDO.setLastName("Bill");
		employeeDO.setAddress("Hyd");
		employeeDO.setActiveIndicator("8");
		employeeDO.setLastUpdatedUserId("112m1a0516");
		employeeDO.setLastUpdatedTmstmp(new Timestamp(2));
		employeeDAO.updateEmployee(employeeDO);

//		assertEquals("20", employeeDO.getEmployeeId());
//		assertEquals("Kill", employeeDO.getFirstName());
//		assertEquals("Bill", employeeDO.getLastName());
//		assertEquals("Hyd", employeeDO.getAddress());
//		assertEquals("7", employeeDO.getActiveIndicator());
//		assertEquals("112m1a0516", employeeDO.getLastUpdatedUserId());

	}

	@Test
	public void testDeleteEmployee() {
		employeeDAO.deleteEmployee("20");
	}
	 
	@Test
	public void deleteEmployee2(){
		employeeDAO.deleteEmployee2("Kill");
	}
	
	@Test
	public void testLoadEmployee() {
		EmployeeDO employeeDO = employeeDAO.getEmployee("20");

		assertEquals("20", employeeDO.getEmployeeId());
		assertEquals("Kill", employeeDO.getFirstName());
		assertEquals("Bill", employeeDO.getLastName());
		assertEquals("Hyd", employeeDO.getAddress());
		assertEquals(null, employeeDO.getActiveIndicator());
//		assertEquals("112m1a0510", employeeDO.getLastUpdatedUserId());
//		assertEquals( 2, employeeDO.getLastUpdatedTmstmp());
	}

}
