package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String age;
	List<String> name=new ArrayList<String>();
	
	public EmployeeRequest() {
		super();
	}
	public EmployeeRequest(int id, String age, List<String> name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmployeeRequest [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
	
	
	

}
