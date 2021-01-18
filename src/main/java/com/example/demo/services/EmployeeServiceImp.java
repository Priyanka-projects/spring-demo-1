package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.EmpDummy;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRequest;

import helper.ExcelHelper;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDAO;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int empid) {
	Employee	empFound=employeeDAO.getEmployeeById(empid);
		return empFound;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		employeeDAO.addEmployee(emp);
		return emp;
	}

	@Override
	public void updateEmployee(List<Employee>emps) {
		for(Employee emp:emps) {
		employeeDAO.updateEmployee(emp);
		}
		
	}

	@Override
	public void deleteEmployee(int empid) {
		employeeDAO.deleteEmployee(empid);
		
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> empList=employeeDAO.getEmployeeByName(name);
		return empList;
	}

	@Override
	public List<Employee> getEmployee(EmployeeRequest empRequest) {
		List<Employee> empList=employeeDAO.getEmployee(empRequest);
		return empList;
	}

	@Override
	public void saveEmployeeis(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
		      List<Employee> employeeis = ExcelHelper.excelToList(file.getInputStream());
		      System.out.println(employeeis.toString());
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
	}

	@Override
	public List<EmpDummy> getEmployees() {
		List<EmpDummy> empList=employeeDAO.getEmployees();
		return empList;
	}

	@Override
	public EmpDummy addEmployeeDummy(EmpDummy emp) {
		employeeDAO.addEmployeeDummy(emp);
		return emp;
	}

	/*@Override
	public List<Employee> getEmployeeByAge(int age) {
		List<Employee> empList=employeeDAO.getEmployeeByAge(age);
		return empList;
		
	}*/

}
