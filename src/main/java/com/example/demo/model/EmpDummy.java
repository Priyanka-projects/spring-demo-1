package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_dummy")
public class EmpDummy {
	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private Long empId;
	@Column(name="username")
	private String empName;
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String emailAddress;
	@Column(name="roles")
	private String roles;

	public Long getEmpId() {
	return empId;
	}
	@Column(name="phone")
	private Long phoneNum;
	public String getEmpName() {
	return empName;
	}
	public void setEmpName(String empName) {
	this.empName = empName;
	}
	public String getEmailAddress() {
	return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
	}
	public Long getPhoneNum() {
	return phoneNum;
	}
	public void setPhoneNum(Long phoneNum) {
	this.phoneNum = phoneNum;
	}

	public String getRoles() {
	return roles;
	}
	public void setRoles(String roles) {
	this.roles = roles;
	}

	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	@Override
	public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", emailAddress=" + emailAddress + ", phoneNum="
	+ phoneNum + "]";
	}

}
