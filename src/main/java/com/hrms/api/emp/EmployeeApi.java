package com.hrms.api.emp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.api.domain.Employee;
import com.hrms.api.dto.EmployeeDTO;

@RequestMapping(value="/api/v1")
public interface EmployeeApi {

	@PostMapping("/emp")
	public ResponseEntity<Employee> saveEmployee(EmployeeDTO empDTO);
	
	@PutMapping("/emp")
	public ResponseEntity<Employee> updateEmployee(EmployeeDTO empDTO);
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id);
	
	@GetMapping("/emp")
	public ResponseEntity<Iterable<Employee>> getAllEmployee();

}
