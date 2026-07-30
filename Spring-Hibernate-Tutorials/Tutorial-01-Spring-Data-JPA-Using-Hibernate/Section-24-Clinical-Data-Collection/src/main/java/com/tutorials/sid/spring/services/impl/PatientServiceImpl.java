/**
 * 
 */
package com.tutorials.sid.spring.services.impl;


import com.tutorials.sid.spring.model.db.PatientDetails;
import com.tutorials.sid.spring.model.dto.PatientDetailsDTO;
import com.tutorials.sid.spring.repositories.PatientRepo;
import com.tutorials.sid.spring.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lenovo
 *
 */
@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public PatientDetails save(PatientDetails patientDetails) {
		return patientRepo.save(patientDetails);
	}

	@Override
	public PatientDetails get(int patientId) {
		return patientRepo.findById(patientId).get();
	}

	@Override
	public PatientDetails getPatientByName(String firstName) {
		return patientRepo.getPatientDetailsByFirstName(firstName);
	}

	@Override
	public PatientDetailsDTO getPatientByLast(String lastName) {
		return patientRepo.getPatientDetailsByLastName(lastName).get(0);
	}

	@Override
	public PatientDetails update(PatientDetails patientDetails) {
		return patientRepo.save(patientDetails);
	}

	@Override
	public List<PatientDetails> getAllPatient() {
		return patientRepo.findAll();
	}

}
