package spring.boot.restfulcrud.service;

import java.util.List;

import spring.boot.restfulcrud.entity.EmployeeEntity;

public interface EmployeeService {

	List<EmployeeEntity> getAllEmployee();
	
	EmployeeEntity getEmployeeById(Long id);
	
	EmployeeEntity saveEmployee(EmployeeEntity emp);
	
	EmployeeEntity updateEmployeeById(Long id, EmployeeEntity empUpdate);
	
	void deleteEmployeeById(Long id);
}
