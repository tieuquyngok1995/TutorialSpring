package spring.boot.restfulcrud.model;

import java.util.Date;

public class Employee {
	private Long id;
	private String fullName;
	private String position;
	private Date dateOfBirth;
	
	public Employee() {
		super();
	}

	public Employee(Long id, String fullName, String position, Date dateOfBirth) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.position = position;
		this.dateOfBirth = dateOfBirth;
	}
	
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", position=" + position + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
}
