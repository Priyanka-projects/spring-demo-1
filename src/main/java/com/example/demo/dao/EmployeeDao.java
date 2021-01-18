package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.EmpDummy;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRequest;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int empid);
    Employee addEmployee(Employee emp);
    void updateEmployee(Employee emp);
    void deleteEmployee(int empid);
    List<Employee>getEmployeeByName(String name);
   // List<Employee>getEmployeeByAge(int age);
	List<Employee> getEmployee(EmployeeRequest empRequest);
	 List<EmpDummy> getEmployees();
	 EmpDummy addEmployeeDummy(EmpDummy emp);
    
  //  boolean EmployeeExists(String title, String category);
}
