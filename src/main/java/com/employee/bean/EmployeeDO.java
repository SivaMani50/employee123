package com.employee.bean;

import java.sql.Timestamp;

public class EmployeeDO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String activeIndicator;
	private String lastUpdatedUserId;
	private Timestamp lastUpdatedTmstmp;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActiveIndicator() {
		return activeIndicator;
	}

	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	public String getLastUpdatedUserId() {
		return lastUpdatedUserId;
	}

	public void setLastUpdatedUserId(String lastUpdatedUserId) {
		this.lastUpdatedUserId = lastUpdatedUserId;
	}

	public Timestamp getLastUpdatedTmstmp() {
		return lastUpdatedTmstmp;
	}

	public void setLastUpdatedTmstmp(Timestamp lastUpdatedTmstmp) {
		this.lastUpdatedTmstmp = lastUpdatedTmstmp;
	}

}
