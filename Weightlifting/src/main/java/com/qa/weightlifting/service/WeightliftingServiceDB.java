package com.qa.weightlifting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.repository.WeightliftingRepository;

@Service
public class WeightliftingServiceDB {
	
	
	private WeightliftingRepository repo;
	
	public WeightliftingServiceDB(WeightliftingRepository repo) {
		this.repo = repo;
	}

	public Weightlifting create(Weightlifting wl) {
		return this.repo.saveAndFlush(wl);
	}

	public List<Weightlifting> getAll() {
		return this.repo.findAll();
	}
 
	public Weightlifting getbyId(Long id) {
		Optional<Weightlifting> optionalRecord = this.repo.findById(id);
		optionalRecord.isPresent();
		return optionalRecord.get();
		
	}  
	 
	public Weightlifting updateRecord(Long id, Weightlifting newWeightlifting) {
		Optional<Weightlifting> optionalRecord = this.repo.findById(id);
		Weightlifting optional = optionalRecord.get();
		
		optional.setFirstName(newWeightlifting.getFirstName());
		optional.setLastName(newWeightlifting.getLastName());
		optional.setBenchPress(newWeightlifting.getBenchPress());
		optional.setCleanAndJ(newWeightlifting.getCleanAndJ());
		optional.setSnatch(newWeightlifting.getSnatch());

		return this.repo.saveAndFlush(optional);
		
	}

	public boolean removeRecord(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}


}
