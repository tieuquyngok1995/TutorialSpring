package org.sbcrudrestful.dao;

import java.util.List;

import org.sbcrudrestful.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employee, String> {

	List<Employee> findByEmpNo(String empNo);
	
	
}
