package com.hrms.api.data;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.hrms.api.domain.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
	

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private EmployeeRepository employeeRepo;
    
    private Employee employee;

	@Before
	public void setUp() throws Exception {
		
		employee = new Employee();
		employee.setName("Test");
	}

	@Test
	public void testSave() {
		entityManager.persist(employee);
		assertThat(employeeRepo.count()).isNotNull().isEqualTo(1);
	}

	@Test
	public void testSaveAll() {
		
	}

	@Test
	public void testFindById() {
	}

	@Test
	public void testFindAll() {
	}

	@Test
	public void testFindAllById() {
	}

	@Test
	public void testDeleteById() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteAll() {
	}

}
