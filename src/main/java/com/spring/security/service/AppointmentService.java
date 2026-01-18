package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.Appointment;
import com.spring.security.repo.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	
	public Appointment bookAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

}
