package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="d_id")
	private int d_id;
	@Column(name="d_name")
	private String d_name;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Employee> empList;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Project> projectList;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Maneger> manegerList;
	
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
	
	public Set<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}
	
	
	public Set<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(Set<Project> projectList) {
		this.projectList = projectList;
	}
	
	
	public Set<Maneger> getManegerList() {
		return manegerList;
	}
	public void setManegerList(Set<Maneger> manegerList) {
		this.manegerList = manegerList;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", d_name=" + d_name + ", empList=" + empList + ", projectList="
				+ projectList + ", manegerList=" + manegerList + "]";
	}
	
	
	

}
