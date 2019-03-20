package com.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.employee.bean.EmployeeDO;

import oracle.net.aso.r;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private JdbcTemplate template;

	public EmployeeDAOImp(JdbcTemplate template){
		this.template = template;
	} 
	
	public void saveEmployee(EmployeeDO employeeDO) {
//		System.out.println(employeeDO.getActiveIndicator());
		
		try {
			template.update(
					"INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME,ADDRESS,ACTIVE_IND,LAST_UPDATED_USERID,LAST_UPDATED_TMSTMP) "
							+ "VALUES('" + employeeDO.getFirstName() + "','" + employeeDO.getLastName() + "','"
							+ employeeDO.getAddress() + "'," + "'" + employeeDO.getActiveIndicator() + "', +'"
							+ employeeDO.getLastUpdatedUserId() + "','" + employeeDO.getLastUpdatedTmstmp() + "')");
		} catch (DataIntegrityViolationException ex) {

		}
	} 
 
	public void updateEmployee(EmployeeDO employeeDO) {
		System.out.println("HelloUpdate");
		template.update("UPDATE EMPLOYEE SET FIRST_NAME= '" + employeeDO.getFirstName() + "',LAST_NAME= '"
				+ employeeDO.getLastName() + "',ADDRESS='" + employeeDO.getAddress() + "',ACTIVE_IND='"
				+ employeeDO.getActiveIndicator() + "',LAST_UPDATED_USERID='" + employeeDO.getLastUpdatedUserId()
				+ "',LAST_UPDATED_TMSTMP=sysdate WHERE EMPLOYEE_ID='" + employeeDO.getEmployeeId()+"'");
	} 

	public void deleteEmployee(String employeeId) {
		template.update("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID= " + employeeId);
	}

	public EmployeeDO getEmployee(String employeeId) {
		try {
			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, ACTIVE_IND, LAST_UPDATED_USERID, LAST_UPDATED_TMSTMP FROM EMPLOYEE WHERE EMPLOYEE_ID= ?";
			return template.queryForObject(sql, new Object[] { employeeId },
					new BeanPropertyRowMapper<EmployeeDO>(EmployeeDO.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<EmployeeDO> findEmployees() {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, ACTIVE_IND, LAST_UPDATED_USERID, LAST_UPDATED_TMSTMP FROM EMPLOYEE";

		List<EmployeeDO> employeeList = template.query(sql, new ResultSetExtractor<List<EmployeeDO>>() {
			public List<EmployeeDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeDO> list = new ArrayList<EmployeeDO>();
				while (rs.next()) {
					EmployeeDO employeeDO = new EmployeeDO();
					employeeDO.setEmployeeId(rs.getString("EMPLOYEE_ID"));
					employeeDO.setFirstName(rs.getString("FIRST_NAME"));
					employeeDO.setLastName(rs.getString("LAST_NAME"));
					employeeDO.setAddress(rs.getString("ADDRESS"));
					employeeDO.setActiveIndicator(rs.getString("ACTIVE_IND"));
					employeeDO.setLastUpdatedUserId(rs.getString("LAST_UPDATED_USERID"));
					employeeDO.setLastUpdatedTmstmp(rs.getTimestamp("LAST_UPDATED_TMSTMP"));
					list.add(employeeDO);
				}

				return list;
			}
		});
		// for(EmployeeDO e : employeeList){
		// System.out.println("e.getFirstName()= "+e.getFirstName());
		// };
		//
		return employeeList;
	}

	public void deleteEmployee2(String firstName) {
		int count = template.update("DELETE FROM EMPLOYEE WHERE FIRST_NAME=" + "'" + firstName + "'");
		System.out.println(count + " deleted");
	}
}
