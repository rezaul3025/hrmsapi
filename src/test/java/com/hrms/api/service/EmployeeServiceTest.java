package com.hrms.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hrms.api.data.EmployeeRepository;
import com.hrms.api.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@MockBean
	private EmployeeRepository empRepo;
	
	@Autowired
	private EmployeeService empService;
	
	private Employee emp;
	
	//@TestConfiguration
    static class EmployeeServiceTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }

	@Before
	public void setUp() throws Exception {
		emp = new Employee();
		emp.setName("test");
	}

	@Test
	public void testSave() {
		empService.save(emp);
		Mockito.verify(empRepo, times(1)).save(emp);
		
	}

	@Test
	public void testUpdate() {
		emp.setId(1L);
		emp.setName("test1");
		empService.update(emp);
		Mockito.verify(empRepo, times(1)).save(emp);

	}

	@Test
	public void testFindOne() {
		emp.setId(2L);
		emp.setName("test2");
		empService.update(emp);
		Mockito.when(empRepo.findById(2L)).thenReturn(Optional.of(emp));
		Employee emp1 = empService.findOne(2L);
		
		assertThat(emp1).isNotNull();
		assertThat(emp1.getId()).isEqualTo(2l);
		assertThat(emp1.getName()).isEqualTo("test2");
	}

	@Test
	public void testFindAll() {
		//fail("Not yet implemented");
	}

}
