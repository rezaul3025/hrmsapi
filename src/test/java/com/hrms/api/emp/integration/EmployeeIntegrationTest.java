package com.hrms.api.emp.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hrms.api.domain.Employee;
import com.hrms.api.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class EmployeeIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EmployeeService empService;
	
	@Test
	public void empIntegrationTest() throws Exception {
		Employee emp = empService.save(new Employee("test"));
		
		assertThat(emp).isNotNull();
		assertThat(emp.getId()).isNotNull().isEqualTo(1);
		assertThat(emp.getName()).isNotNull().isEqualTo("test");
		
		mockMvc.perform(get("/api/v1/emp/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("test"));
		
	}

}
