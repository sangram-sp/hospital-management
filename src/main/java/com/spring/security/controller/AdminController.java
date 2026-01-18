package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Doctor;
import com.spring.security.repo.DoctorRepository;

@RestController
public class AdminController {
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	@PostMapping("/add-doctor")
	public Doctor addDocktor(@RequestBody Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	@GetMapping("/patients")
	public ResponseEntity<?>  getAllPatients(){
		
		return null;
	}

}
