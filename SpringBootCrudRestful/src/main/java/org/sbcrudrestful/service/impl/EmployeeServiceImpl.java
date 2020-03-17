package org.sbcrudrestful.service.impl;

import org.sbcrudrestful.dao.EmployRepository;
import org.sbcrudrestful.exception.NameSpecialException;
import org.sbcrudrestful.model.Employee;
import org.sbcrudrestful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployRepository employRep;
	
	@Override
	public Employee create(Employee e) throws NameSpecialException {
		if (e.getEmpName().equals("tuan")) {
			throw new NameSpecialException("name special"); 
		} else {
			return employRep.save(e);
		}
	}

}
