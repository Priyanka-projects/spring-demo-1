package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.Getter;
//import lombok.Setter;


@Entity
@Table(name="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private int e_id;
	@Column(name="emp_name")
	private String name;
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date bDate;
	
	private int age;
	@Column(name="emp_email")
	private String email;
	@Column(name="emp_phone")
	private String phone;
	@Column(name="emp_address")
	private String address;
	@Column(name="emp_hiredate")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = { @JoinColumn(name = "p_id") })
	
	private Set<Project> project = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="d_id")
	private Department department;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return e_id;
	}
	public void setId(int e_id) {
		this.e_id = e_id;
	}
	
	@Formula(value="select timestampdiff('year',birth_date,curdate()) from employee where emp_id=id")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
		this.project = project;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + ", bDate=" + bDate + ", age=" + age + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", hireDate=" + hireDate + ", project=" + project
				+ ", department=" + department + "]";
	}
	
	
	
	
	
	
	

}
