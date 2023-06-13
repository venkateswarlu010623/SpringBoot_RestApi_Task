package com.Employee.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Employee.modal.Employee;

@Service
public class EmployeeService {
	
	List<Employee> employee1 = new LinkedList<>();
	
	
	public List<Employee> saveAllEmployee(List<Employee> employee)
	{
		 employee1.addAll(employee);
		
		return employee1;
	}
	

	//1.Retrieve all employees in India
	
	public List<Employee> getAllEmployeeInIndia(String country)
	{
		return  employee1.stream()
						.filter(e->e.getLocation().getLocationCountry().equalsIgnoreCase(country))
						.collect(Collectors.toList());
	}
	
	//2.Retrieve employees who are in Chennai or Hyderabad

	public List<Employee> getAllEmployeesByCities(String city1,String city2)
	{
		return employee1.stream()
						.filter(e->e.getLocation().getLocationName().equalsIgnoreCase(city1) ||
								e.getLocation().getLocationName().equalsIgnoreCase(city2))
						.collect(Collectors.toList());
	}
	
	
	//3. Retrieve employees who have Benefits and display benefits details

		public List<String> getAllEmployeesWithBenefits()
		{
			return employee1.stream()
							.filter(e->e.getBenefits() != null)
							.map(emp->"EmployeeName ="+emp.getEmployeeName()+" "+"EmployeeBenefits ="+emp.getBenefits())
							.collect(Collectors.toList());
		}
		
	//4.Retrieve employee details -  employeeId, employeeName, Salary, deptName, locationName, locationCountry
			
		public List<String> getAllEmployeeDetails()
		{
			return employee1.stream()
							.map(e->
								"employeeId="+e.getEmployeeId()+
								" employeeName= "+e.getEmployeeName() +
								" Salary= "+e.getSalary()+
								" departmentName= "+e.getDepartment().getDepartmentName()+
								" locationName="+e.getLocation().getLocationName()+
								" locationCountry"+e.getLocation().getLocationCountry())
							.collect(Collectors.toList());
		}
		
	//5.Retrieve employees who are in Chennai and India
		
		public List<Employee> getAllEmployeesInCityAndCountry(String city, String country)
		{
			return employee1.stream()
							.filter(e->e.getLocation().getLocationCountry().equalsIgnoreCase(country)&&
								e.getLocation().getLocationName().equalsIgnoreCase(city))
							.collect(Collectors.toList());

			
		}
		
		
		
		public List<Employee> getOneEmployeeById(int id)
		{

			return employee1.stream().filter(emp->emp.getEmployeeId() == id)
									.collect(Collectors.toList());
			
		}
		
		public void deleteOneEmployee(int id)
		{

			List<Employee> emp2 = employee1.stream()
											.filter(emp->!(emp.getEmployeeId() == id))
											.collect(Collectors.toList());

			employee1.clear();
			employee1.addAll(emp2);
			
		}




}