package spring.boot.restfulcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.restfulcrud.entity.EmployeeEntity;
import spring.boot.restfulcrud.service.EmployeeServiceImpl;

@RestController
public class MainRESTCOntroller {

	@Autowired
	private EmployeeServiceImpl empService;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity emp) {
		System.out.println("add employee "+ emp.toString());
		return empService.saveEmployee(emp);
	}
}
