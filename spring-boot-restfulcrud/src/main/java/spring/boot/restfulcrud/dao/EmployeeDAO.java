package spring.boot.restfulcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.restfulcrud.entity.EmployeeEntity;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {

	public List<EmployeeEntity> findAll();
	
	public Optional<EmployeeEntity> findById(Long id);
	
}
