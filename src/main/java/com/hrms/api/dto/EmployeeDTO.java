package com.hrms.api.dto;

import javax.validation.constraints.Size;

public class EmployeeDTO {
	private Long id;
	
	@Size(min=3, max=30, message="Name must be between 3 and 30 chars")
	
	public EmployeeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public EmployeeDTO() {
		
	}
	
	private String name;

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
	
	
}
