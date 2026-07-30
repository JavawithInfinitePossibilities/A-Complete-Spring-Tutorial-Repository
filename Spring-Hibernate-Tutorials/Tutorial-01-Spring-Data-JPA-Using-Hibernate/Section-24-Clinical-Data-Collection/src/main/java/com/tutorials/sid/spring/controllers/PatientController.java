/**
 * 
 */
package com.tutorials.sid.spring.controllers;


import com.tutorials.sid.spring.model.db.PatientDetails;
import com.tutorials.sid.spring.model.dto.PatientDetailsDTO;
import com.tutorials.sid.spring.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lenovo
 *
 */
@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private IPatientService iPatientService;

	@RequestMapping(value = "/getAllPatient", method = RequestMethod.GET)
	private List<PatientDetails> getAllPatient() {
		return iPatientService.getAllPatient();
	}

	@RequestMapping(value = "/getPatientById/{patientId}", method = RequestMethod.GET)
	public PatientDetails getPatient(@PathVariable("patientId") int patientId) {
		return iPatientService.get(patientId);
	}

	@RequestMapping(value = "/getPatientByLastName/{patientLastName}", method = RequestMethod.GET)
	public PatientDetailsDTO getPatientByLastName(@PathVariable("patientLastName") String patientLastName) {
		return iPatientService.getPatientByLast(patientLastName);
	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public PatientDetails savePatient(@RequestBody PatientDetails patientDetails) {
		return iPatientService.save(patientDetails);
	}
}
