package spring.boot.restfulcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<EmployeeEntity> getAllEmployee(){
		return empService.getAllEmployee();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeEntity getEmployeeById(@RequestParam("id") Long id){
		return empService.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeEntity addEmployee(EmployeeEntity emp) {
		return empService.saveEmployee(emp);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	@ResponseBody
	public EmployeeEntity updateEmployeeById(Long id, EmployeeEntity emp) {
		return empService.updateEmployeeById(id, emp);
	}
}
