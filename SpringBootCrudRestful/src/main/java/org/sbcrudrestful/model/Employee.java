package org.sbcrudrestful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private String empNo;
	@Column
	private String empName;
	@Column
	private String position;
	
	public Employee() {
		super();
	}
	
	public Employee(String empNo, String empName, String position) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", position=" + position + "]";
	}
	
}
