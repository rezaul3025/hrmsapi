package com.hrms.api.emp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.api.domain.Employee;
import com.hrms.api.dto.EmployeeDTO;
import com.hrms.api.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeApiImp.class)
public class EmployeeApiImpTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService empService;
	
	@Autowired 
    private ObjectMapper objectMapper;
    
    private JacksonTester<EmployeeDTO> jsonTesterEmp;

	@Before
	public void setUp() throws Exception {
		JacksonTester.initFields(this, objectMapper);
		Employee emp = new Employee(2l, "test");
		Mockito.when(empService.save(emp)).thenReturn(emp);	
		
		Employee emp1 = new Employee(2l, "test1");
		Mockito.when(empService.update(emp1)).thenReturn(emp1);	
		
		Employee emp2 = new Employee(3l, "test2");
		Mockito.when(empService.findOne(3l)).thenReturn(emp2);	
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);
		Mockito.when(empService.findAll()).thenReturn(empList);

	}

	@Test
	public void testSameEmployee() throws Exception {
   	 	final String empDTOJson = jsonTesterEmp.write(new EmployeeDTO(2l,"test")).getJson();

		mockMvc.perform(post("/api/v1/emp")
				.content(empDTOJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(2))
				.andExpect(jsonPath("$.name").value("test"));
			     
				
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		final String empDTOJson = jsonTesterEmp.write(new EmployeeDTO(2l,"test1")).getJson();

		mockMvc.perform(put("/api/v1/emp")
				.content(empDTOJson).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(2))
				.andExpect(jsonPath("$.name").value("test1"));
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		mockMvc.perform(get("/api/v1/emp/3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.name").value("test2"));
	}

	@Test
	public void testGetAllEmployee() throws Exception {
		mockMvc.perform(get("/api/v1/emp")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[2].id").value(3))
				.andExpect(jsonPath("$[2].name").value("test2"));
	}

}
