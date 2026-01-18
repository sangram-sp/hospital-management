package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Appointment;
import com.spring.security.service.AppointmentService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/book")
	public Appointment book(@RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
	}

}
