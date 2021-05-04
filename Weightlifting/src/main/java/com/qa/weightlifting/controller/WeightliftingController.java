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
import com.qa.weightlifting.service.WeightliftingService;

@RestController
public class WeightliftingController {

	private WeightliftingService service;
	
	public WeightliftingController(WeightliftingService service) {
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
	
	@GetMapping("getOne/{index}")
	public ResponseEntity<Weightlifting> getRecordById(@PathVariable int index) {
		return ResponseEntity.ok(this.service.getbyId(index));
	}
	
	@DeleteMapping("/remove/{index}")
	public ResponseEntity<Boolean> removeRecord(@PathVariable int index) {
		return ResponseEntity.ok(this.service.removeRecord(index));
	}
	
//	@PutMapping("/update")
//	public Weightlifting updateRecord(@PathParam("index") int index, @RequestBody Weightlifting weightlifting) {
//		
//	
//		this.service.removeRecord(index);
//		this.service.add(index, weightlifting);
//		return this.service.get(index);
//	}
}







