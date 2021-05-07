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
		
		
		Optional<Weightlifting> optionalRecord = Optional.of(new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80));
		Weightlifting returnPerson = new Weightlifting(1L, "Mark", "Tinman", 140, 110, 80);
		
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalRecord);
		
		assertThat(this.service.getbyId(1L)).isEqualTo(returnPerson);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	} 
	
	@Test
	void updateRecord() {
		Optional<Weightlifting> optionalRecord = Optional.of(new Weightlifting(1L,"Mark", "Tinman", 140, 110, 80));
		
		Weightlifting optional = optionalRecord.get();
		 
		Mockito.when(this.repo.findById(1L)).thenReturn(optionalRecord);
		
		
		assertThat(this.service.updateRecord(1L, optional));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(optional);
	}
	 
	@Test 
	void removeRecord() {
		
		Mockito.when(this.repo.existsById(1L)).thenReturn(true,false);
		
		assertThat(this.service.removeRecord(1L)).isEqualTo(false);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	 
	@Test
	void removeRecordTwo() {
		
		Mockito.when(this.repo.existsById(2L)).thenReturn(true,false);
		
		assertThat(this.service.removeRecord(1L)).isEqualTo(true);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
}
