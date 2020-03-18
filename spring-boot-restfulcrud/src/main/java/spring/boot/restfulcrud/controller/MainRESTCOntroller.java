package spring.boot.restfulcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.restfulcrud.dao.EmployeeDAO;
import spring.boot.restfulcrud.entity.EmployeeEntity;
import spring.boot.restfulcrud.service.EmployeeServiceImpl;

@RestController
public class MainRESTCOntroller {

	@Autowired
	private EmployeeDAO empDao;
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example";
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<EmployeeEntity> getAllEmployee(){
		return empService.getAllEmployee();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public EmployeeEntity getEmployeeById(Long id){
		return empDao.findById(id).get();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	public EmployeeEntity addEmployee(EmployeeEntity emp) {
		return empService.saveEmployee(emp);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public EmployeeEntity updateEmployeeById(@RequestParam Long id, @RequestBody EmployeeEntity emp) {
		return empService.updateEmployeeById(id, emp);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.DELETE)
	public String deleteEmployeeById(Long id) {
		empDao.deleteById(id);
		return "Delete done";
	}
}
