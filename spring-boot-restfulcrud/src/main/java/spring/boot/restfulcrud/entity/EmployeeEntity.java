package spring.boot.restfulcrud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name="Id", nullable = false)
	private Long id;
	
	@Column(name="Full_Name", length=64, nullable = false)
	private String fullName;
	
	@Column(name="Position", length=64)
	private String position;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_Of_Birth", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
