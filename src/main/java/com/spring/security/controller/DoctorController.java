package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Appointment;
import com.spring.security.repo.AppointmentRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@GetMapping("/appointments")
	public List<Appointment> getAppointments(){
		return appointmentRepo.findAll();
	}
}
