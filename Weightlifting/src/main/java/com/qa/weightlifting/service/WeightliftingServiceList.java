package com.qa.weightlifting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.weightlifting.domain.Weightlifting;

@Service
public class WeightliftingServiceList implements WeightliftingService{
	
	private List<Weightlifting> weightliftingList;
	
	public WeightliftingServiceList(List<Weightlifting> weightliftingList) {
		this.weightliftingList = weightliftingList;
	}

	@Override
	public Weightlifting create(Weightlifting wl) {
		this.weightliftingList.add(wl);
		Weightlifting added = this.weightliftingList.get(this.weightliftingList.size() - 1);
		return added;
	}

	@Override
	public List<Weightlifting> getAll() {
		return this.weightliftingList;
	}

	@Override
	public Weightlifting getbyId(int id) {
		return this.weightliftingList.get(id);
	}

	
	@Override
	public boolean removeRecord(int id) {
		 this.weightliftingList.remove(id);
		 return true;
	}


	@Override
	public Weightlifting updateRecord(int id, Weightlifting newWeightlifting) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
