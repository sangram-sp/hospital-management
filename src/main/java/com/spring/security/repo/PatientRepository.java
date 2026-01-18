package com.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
