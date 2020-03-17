package org.sbcrudrestful.service;

import org.sbcrudrestful.exception.NameSpecialException;
import org.sbcrudrestful.model.Employee;

public interface EmployeeService {
	public Employee create(Employee e) throws NameSpecialException;
}
