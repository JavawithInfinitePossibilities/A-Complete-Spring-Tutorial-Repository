/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.db.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface PatientRepo extends JpaRepository<PatientDetails, Integer> {

	public PatientDetails getPatientDetailsByFirstName(String firstName);

}
