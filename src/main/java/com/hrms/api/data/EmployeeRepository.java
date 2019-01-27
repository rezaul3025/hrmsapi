package com.hrms.api.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hrms.api.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
