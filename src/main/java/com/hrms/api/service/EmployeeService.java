package com.hrms.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.api.data.EmployeeRepository;
import com.hrms.api.domain.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee findOne(Long id) {
		return employeeRepository.findById(id).orElse(new Employee());
	}
	
	public Iterable<Employee> findAll(){
		return employeeRepository.findAll();
	}
}
