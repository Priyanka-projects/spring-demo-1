package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.EmpDummy;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRequest;
@Transactional
@Repository
public class EmployeeDaoImp  implements EmployeeDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String hql = "FROM employee as empl ORDER BY emp.emp_id";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Employee getEmployeeById(int empid) {
		//return entityManager.find(Employee.class, empid);
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> empRoot = criteria.from(Employee.class);
    	criteria.select(empRoot).where(builder.equal(empRoot.get("e_id"), empid));
		List<Employee> empList = entityManager.createQuery(criteria).getResultList();
		//System.out.println(empList.get(0));
		return empList.get(0);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		entityManager.persist(emp);
		System.out.println(emp.getAge());
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		Employee emp1 = getEmployeeById(emp.getId());
		emp1.setName(emp.getName());
		emp1.setAge(emp.getAge());
		entityManager.flush();
		
	}

	@Override
	public void deleteEmployee(int empid) {
		entityManager.remove(getEmployeeById(empid));
		
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> empRoot = criteria.from(Employee.class);
		criteria.select(empRoot).where(builder.like(empRoot.get("name"), "%"+name+"%"));
		List<Employee> empList = entityManager.createQuery(criteria).getResultList();
		return empList;
		
	}
	
	
	

	
	
	
	@Override
	public List<Employee> getEmployee(EmployeeRequest empRequest) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> empRoot = criteria.from(Employee.class);
		List<Predicate> predicates = new ArrayList<>();
			
		predicates.add(builder.equal(empRoot.get("id"), empRequest.getId()));
		if(null != empRequest.getName() || !empRequest.getName().isEmpty()){
			for (String empName : empRequest.getName()) {
				String searchNamedString = "%".concat(empName).concat("%");
				predicates.add(builder.like(empRoot.get("name"), searchNamedString));
			}
		}
		
		if (null!= empRequest.getAge()) {
			List<Integer> ageRange = Arrays.asList(empRequest.getAge().split(":")).stream().map(age -> {
				return Integer.parseInt(age.toString());
			}).collect(Collectors.toList());
			predicates.add(ageRange.size() > 1 ? builder.between(empRoot.get("age"), ageRange.get(0), ageRange.get(1))
					: builder.equal(empRoot.get("age"), ageRange.get(0)));
		}
		
		criteria.select(empRoot/*.get("name")*/).where(
					builder.or(predicates.toArray(new Predicate[predicates.size()])));
		List<Employee> empList = entityManager.createQuery(criteria).getResultList();
		return empList;
	}

	@Override
	public List<EmpDummy> getEmployees() {
		//String hql = "FROM emp_dummy as empl ORDER BY emp.emp_id";
		//return (List<EmpDummy>) entityManager.createQuery(hql).getResultList();
		return entityManager.createQuery("from EmpDummy").getResultList();
		/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmpDummy> criteria = builder.createQuery(EmpDummy.class);
		List<EmpDummy> empList = entityManager.createQuery(criteria).getResultList();
		return empList;*/
		
	
	}

	@Override
	public EmpDummy addEmployeeDummy(EmpDummy emp) {
		entityManager.persist(emp);
		
		return emp;
	}
	
	
	
}
