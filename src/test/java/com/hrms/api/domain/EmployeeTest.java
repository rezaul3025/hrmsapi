package com.hrms.api.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	
	private Employee emp;

	@Before
	public void setUp() throws Exception {
		emp = new Employee();
	}

	@Test
	public void testGetId() {

	}

	@Test
	public void testSetId() {
		emp.setId(null);
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		emp.setName("3");
	}

}
