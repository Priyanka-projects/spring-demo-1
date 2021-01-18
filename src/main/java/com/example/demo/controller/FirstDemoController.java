package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.EmpDummy;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.services.EmployeeService;

import helper.ExcelHelper;
import message.ResponseMessage;
@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/employee")

public class FirstDemoController {
	@Autowired
	private EmployeeService empService;
	@PostMapping(path="/saveEmployee")
     public Employee getDetails(@RequestBody Employee employee) {
		//System.out.println(employee);
		return empService.addEmployee(employee);
		
	}
	
	@PostMapping(path="/saveEmployeeDummy")
    public EmpDummy getDetails(@RequestBody EmpDummy employee) {
		//System.out.println(employee);
		return empService.addEmployeeDummy(employee);
		
	}
	
	@GetMapping(path="/getAEmployee/{id}")
	public Employee getAEmployee(@PathVariable int id) {
		//System.out.println(employee);
		return empService.getEmployeeById(id);
		
	}
	
	@GetMapping(path="/getEmployeeByName/{name}")
	public List<Employee> getAEmployee(@PathVariable String name) {
		//System.out.println(employee);
		return empService.getEmployeeByName(name);
		
	}
	
	@PostMapping(path="/deleteAEmployee")
	public String deleteAEmployee(@RequestBody int empid) {
		//System.out.println(employee);
		 empService.deleteEmployee(empid);
		return empid+" deleted";
	}
	
	@PostMapping(path="/updateEmployee")
	public List<Employee> updateEmployee(@RequestBody List<Employee> emps) {
		//System.out.println(employee);
		 empService.updateEmployee(emps);
		 List<Employee> femp=new ArrayList<Employee>();
		 for(Employee emp:emps) {
			femp.add(empService.getEmployeeById(emp.getId()));
		 }
		return femp;
	}
	
	@PostMapping(path="/getEmployee")
    public List<Employee> getEmployee(@RequestBody EmployeeRequest empRequest) {
		
		/*List<Employee> flist1;
		List <Employee>flist2=new ArrayList<>();
		
		if(emp.getId()==0 && emp.getName()=="null")
		{
			flist1=empService.getEmployeeByAge(emp.getAge());
			return flist1;
		}
		else if(emp.getId()==0 && emp.getAge()==0) {
			flist1=empService.getEmployeeByName(emp.getName());
			return flist1;
		}
		else {
			Employee e=empService.getEmployeeById(emp.getId());
			flist2.add(e);
			return flist2;
		}*/
		
	List<Employee> empList=	empService.getEmployee(empRequest);
		
		
		
		return empList;
	}
	
	
	@GetMapping(path="/getEmployees")
    public List<EmpDummy> getEmployees() {
		
		/*List<Employee> flist1;
		List <Employee>flist2=new ArrayList<>();
		
		if(emp.getId()==0 && emp.getName()=="null")
		{
			flist1=empService.getEmployeeByAge(emp.getAge());
			return flist1;
		}
		else if(emp.getId()==0 && emp.getAge()==0) {
			flist1=empService.getEmployeeByName(emp.getName());
			return flist1;
		}
		else {
			Employee e=empService.getEmployeeById(emp.getId());
			flist2.add(e);
			return flist2;
		}*/
		
	List<EmpDummy> empList=	empService.getEmployees();
		
		
		
		return empList;
	}
	
	@PostMapping(path="/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	        empService.saveEmployeeis(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!"+
	      e;
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	
	
}
