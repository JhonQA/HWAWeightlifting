package com.qa.weightlifting.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.repository.WeightliftingRepository;

@SpringBootTest
public class WeightliftingServiceDBUnitTest {

	@Autowired
	private WeightliftingServiceDB service;
	
	@MockBean
	private WeightliftingRepository repo;
	
	@Test
	void testCreate() {
		
		Weightlifting person = new Weightlifting("Mark", "Tinman", 140, 110, 80);
		Weightlifting savedPerson = new Weightlifting(1L, "Mark", "Tinman", 140, 110, 80);
		
		
		Mockito.when(this.repo.saveAndFlush(person)).thenReturn(savedPerson);
		
		assertThat(this.service.create(person)).isEqualTo(savedPerson);
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(person);
	}
	
	
	@Test
	void testGetAll() {
		
		ArrayList<Weightlifting> person = new ArrayList<Weightlifting>();
		person.add(new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80));
		
		Mockito.when(this.repo.findAll()).thenReturn(person);
		
		assertThat(this.service.getAll()).isEqualTo(person);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	@Test
	void testGetById() {
		Optional<Weightlifting> person = new ;
		Weightlifting savedPerson = new Weightlifting(1L, "Mark", "Tinman", 140, 110, 80);
		
		Mockito.when(this.repo.findById(1L)).thenReturn(person);
		
		assertThat(this.service.getbyId(1L)).isEqualTo(savedPerson);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
}
