package com.spring.security.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Doctor;
import com.spring.security.model.User;
import com.spring.security.repo.DoctorRepository;
import com.spring.security.repo.UserRepository;

@RestController
public class AdminController {
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/add-doctor")
	public Doctor addDocktor(@RequestBody Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	@GetMapping("/findAll")
	public List<Doctor> findAll(){
		return doctorRepo.findAll();
	}
	
	@GetMapping("/findAllUser")
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	
	
	@GetMapping("/patients")
	public ResponseEntity<?>  getAllPatients(){
		
		return null;
	}

}
