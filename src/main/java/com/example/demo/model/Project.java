package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="project")
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="p_id")
	private int p_id;
	@Column(name="p_name")
	private String p_name;
	@Column(name="p_des")
	private String p_des;
	
	@JsonIgnore
	@ManyToMany(/*fetch=FetchType.LAZY,*/mappedBy="project")
	private Set<Employee> employee = new HashSet<>();
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="d_id")
	private Department department;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="m_id")
	private Maneger maneger;
	
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_des() {
		return p_des;
	}
	public void setP_des(String p_des) {
		this.p_des = p_des;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public Maneger getManeger() {
		return maneger;
	}
	public void setManeger(Maneger maneger) {
		this.maneger = maneger;
	}
	@Override
	public String toString() {
		return "Project [p_id=" + p_id + ", p_name=" + p_name + ", p_des=" + p_des + ", employee=" + employee
				+ ", department=" + department + ", maneger=" + maneger + "]";
	}
	
	
	
	
	
	
	
}
