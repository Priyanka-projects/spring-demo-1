package com.example.demo.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.EmpDummy;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRequest;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
    Employee getEmployeeById(int empid);
    Employee addEmployee(Employee emp);
    void updateEmployee(List<Employee> emps);
    void deleteEmployee(int empid);
    List<Employee>getEmployeeByName(String name);
   // List<Employee>getEmployeeByAge(int age);
    List<Employee> getEmployee(EmployeeRequest empRequest);
    void saveEmployeeis(MultipartFile file);
    List<EmpDummy> getEmployees();
    EmpDummy addEmployeeDummy(EmpDummy emp);
    
}
