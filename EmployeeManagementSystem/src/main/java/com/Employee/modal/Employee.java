package com.Employee.modal;


import java.util.List;


public class Employee {

	int employeeId;
	String employeeName;
	int salary;
	Location location;
	Department department;
	List<Benefits>benefits;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int salary, Location location, Department department,
			List<Benefits> benefits) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.location = location;
		this.department = department;
		this.benefits = benefits;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Benefits> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", location=" + location + ", department=" + department + ", benefits=" + benefits + "]";
	}
}
