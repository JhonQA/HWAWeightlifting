package com.qa.weightlifting.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.service.WeightliftingServiceDB;

@RestController
public class WeightliftingController {

	private WeightliftingServiceDB service;
	
	public WeightliftingController(WeightliftingServiceDB service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Weightlifting> createRecord(@RequestBody Weightlifting weightlifting) {
		
		return new ResponseEntity<Weightlifting>(this.service.create(weightlifting), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll") 
	public ResponseEntity<List<Weightlifting>> getWeightlifting(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("getOne/{id}")
	public ResponseEntity<Weightlifting> getRecordById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getbyId(id));
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> removeRecord(@PathVariable Long id) {
		return this.service.removeRecord(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Weightlifting> updateRecord(@PathVariable Long id, @RequestBody Weightlifting newWeightlifting) {
		return new ResponseEntity<Weightlifting>(this.service.updateRecord(id, newWeightlifting), HttpStatus.ACCEPTED);
	}
}







