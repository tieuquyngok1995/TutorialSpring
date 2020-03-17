package org.java.hellorestful.controller;

import org.java.hellorestful.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestfulControler {

	@Autowired
	RestTemplate rest;

	@RequestMapping("/sayhello")
	public String welcome(String code) throws InterruptedException {
		String crudrest = "http://localhost:8080/employee?empNo=";
//		ResponseEntity<Employee> response = rest.getForEntity(crudrest + code, Employee.class);
		Thread.sleep(10000);
		System.out.println(Thread.currentThread().getName());
		return "Hello " + "a";
	}

	@RequestMapping("/hello")
	public String create(Employee e) throws InterruptedException {

		Employee newEmployee = new Employee("E05", "Tom", "Cleck");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		headers.setContentType(MediaType.APPLICATION_XML);

//		HttpEntity<Employee> request = new HttpEntity<>(newEmployee, headers);
//
//		String crudrest = "http://localhost:8080/employee";
//
//		Employee response = rest.postForObject(crudrest, request, Employee.class);

		Thread.sleep(10000);
		return "Hello ";
	}

}
