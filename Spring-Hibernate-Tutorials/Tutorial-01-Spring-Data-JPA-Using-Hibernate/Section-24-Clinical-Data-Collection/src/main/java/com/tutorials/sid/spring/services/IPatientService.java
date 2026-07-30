/**
 * 
 */
package com.tutorials.sid.spring.services;



import com.tutorials.sid.spring.model.db.PatientDetails;
import com.tutorials.sid.spring.model.dto.PatientDetailsDTO;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public interface IPatientService {

	public PatientDetails save(PatientDetails patientDetails);

	public PatientDetails get(int patientId);

	public PatientDetails getPatientByName(String firstName);

	public PatientDetailsDTO getPatientByLast(String lastName);

	public PatientDetails update(PatientDetails patientDetails);

	public List<PatientDetails> getAllPatient();
}
