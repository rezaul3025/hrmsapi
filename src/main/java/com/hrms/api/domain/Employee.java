package com.hrms.api.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull(message="Id can not be null")
	private Long id;
	
	@Size(min=3, max=30, message="Name must contain atlest 3 and maximum 30 character")
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public Employee(Long id, String name) {
		this.id =  id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o) {
			return true;
		}
		
		if(getClass() != o.getClass()) {
			return false;
		}
		
		Employee emp = (Employee) o;
		
		return Objects.equals(this.id,emp.id) && Objects.equals(this.name,emp.name);
	}
}
