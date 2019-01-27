package com.hrms.api.emp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.api.domain.Employee;
import com.hrms.api.dto.EmployeeDTO;
import com.hrms.api.service.EmployeeService;

@RestController
public class EmployeeApiImp implements EmployeeApi {
	
	@Autowired
	private EmployeeService empService;

	@Override
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO empDTO) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Employee>(empService.save(new Employee(empDTO.getId(), empDTO.getName())), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeDTO empDTO) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Employee>(empService.update(new Employee(empDTO.getId(),empDTO.getName())), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(@Valid Long id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Employee>(empService.findOne(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Iterable<Employee>> getAllEmployee() {
		// TODO Auto-generated method stub
		return new ResponseEntity<Iterable<Employee>>(empService.findAll(), HttpStatus.OK);
	}
}
