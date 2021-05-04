package com.qa.weightlifting.service;

import java.util.List;

import com.qa.weightlifting.domain.Weightlifting;

public interface WeightliftingService {
	
	Weightlifting create(Weightlifting wl);
	List<Weightlifting> getAll();
	Weightlifting getbyId(int index);
	Weightlifting updateRecord(int id, Weightlifting newWeightlifting);
	boolean removeRecord(int id);
	

}
