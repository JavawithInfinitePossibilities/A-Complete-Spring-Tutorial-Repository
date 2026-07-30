/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.db.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface DoctorRepo extends JpaRepository<DoctorDetails, Integer> {

	public DoctorDetails getDoctorDetailsByFirstName(String firstName);

}
