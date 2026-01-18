package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.security.model.Doctor;
import com.spring.security.model.User;
import com.spring.security.repo.DoctorRepository;
import com.spring.security.repo.UserRepository;

import jakarta.transaction.Transactional;

public class PersistService {

	@Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        User savedUser = userRepository.save(doctor.getUser());
        doctor.setUser(savedUser);
        return doctorRepository.save(doctor);
    } 
}
