package spring.boot.restfulcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.restfulcrud.dao.EmployeeDAO;
import spring.boot.restfulcrud.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;
	
	public List<EmployeeEntity> getAllEmployee() {
		return empDAO.findAll();
	}

	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		return empDAO.save(emp);
	}

	public EmployeeEntity updateEmployeeById(Long id, EmployeeEntity empUpdate) {
		EmployeeEntity empFromDb = empDAO.findById(id).get();
		empFromDb.setFullName(empUpdate.getFullName());
		empFromDb.setPosition(empUpdate.getPosition());
		empFromDb.setDateOfBirth(empUpdate.getDateOfBirth());
		return empDAO.save(empFromDb);
	}

}
