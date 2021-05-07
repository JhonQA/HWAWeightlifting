package com.qa.weightlifting.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.weightlifting.domain.Weightlifting;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"}, executionPhase= ExecutionPhase.BEFORE_TEST_METHOD) 
@ActiveProfiles("test")
public class WeightliftingControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;

	
	@Test
	void testCreate() throws Exception {
		Weightlifting person = new Weightlifting("Mark", "Tinman", 140, 110, 80);
		
		String personAsJSON= this.mapper.writeValueAsString(person);
		
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(personAsJSON);
		
		Weightlifting savedPerson = new Weightlifting(2L, "Mark", "Tinman", 140, 110, 80);
		
		String savedPersonAsJSON = this.mapper.writeValueAsString(savedPerson);
		
		ResultMatcher matchStatus= status().isCreated();
		
		ResultMatcher matchBody= content().json(savedPersonAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
	}
	 
	@Test
	void testGetAll() throws Exception{
		
		ArrayList<Weightlifting> person = new ArrayList<Weightlifting>();
		person.add(new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80));
		
		String personAsJSON= this.mapper.writeValueAsString(person);
		
		RequestBuilder mockRequest = get("/getAll");
		
		ResultMatcher matchStatus= status().isOk();
		
		ResultMatcher matchBody= content().json(personAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
	} 
	 
	@Test
	void testGetById() throws Exception{
		
		Weightlifting person = new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80);
		
		String personAsJSON= this.mapper.writeValueAsString(person);
		
		
		RequestBuilder mockRequest = get("/getOne/{id}", 1);
		
		ResultMatcher matchStatus= status().isOk();
		
		ResultMatcher matchBody= content().json(personAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
	}
	
	
	@Test
	void testUpdateRecord() throws Exception{
		
		
		
		
		Weightlifting person = new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80);
		
		String personAsJSON= this.mapper.writeValueAsString(person);
		
		
		RequestBuilder mockRequest = put("/update/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(personAsJSON);
		
		Weightlifting savedPerson = new Weightlifting(1L, "Tim", "Kennen", 60, 40, 20);
		
		String savedPersonAsJSON = this.mapper.writeValueAsString(savedPerson);
	
		ResultMatcher matchStatus= status().isAccepted();
		
		ResultMatcher matchBody= content().json(savedPersonAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testRemoveRecord() throws Exception{

		RequestBuilder mockRequest = delete("/remove/{id}", 1).contentType(MediaType.APPLICATION_JSON);
		ResultMatcher matchStatus= status().isNoContent();
		
	
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);

	}
	
//	@Test
//	void testRemoveRecordFail() throws Exception{
//	
//		RequestBuilder mockRequest = delete("/remove/{id}", 2).contentType(MediaType.APPLICATION_JSON);
//		ResultMatcher matchStatusError= status().isInternalServerError();
//	
//		this.mockMVC.perform(mockRequest).andExpect(matchStatusError);
//
//	}
	
}
