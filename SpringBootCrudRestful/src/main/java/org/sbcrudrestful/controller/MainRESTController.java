package org.sbcrudrestful.controller;

import java.util.List;

import org.sbcrudrestful.dao.EmployRepository;
import org.sbcrudrestful.exception.NameSpecialException;
import org.sbcrudrestful.model.Employee;
import org.sbcrudrestful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Lớp MainRESTController được chú thích (annotate) bởi @RestController
//để thông báo với Spring rằng nó là một Spring Restful Controller

@RestController
public class MainRESTController {

	@Autowired
	private EmployRepository employDao;
	@Autowired
	EmployeeService employService;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Hello Word";
	}
	
	@RequestMapping(value = "/employees",
			method = RequestMethod.GET)
	public List<Employee> getEmployee() {
		return employDao.findAll();
	}
	
	@RequestMapping(value = "/employee", 
            method = RequestMethod.GET)
    public Employee getEmployee( String empNo) {
        return employDao.findById(empNo).get();
    }
	
	@RequestMapping(value = "/employee", 
			method = RequestMethod.POST)
	public Employee createEmp(Employee e) throws NameSpecialException {
		System.out.println("rest main" + e);
		return employService.create(e);
	} 
}
