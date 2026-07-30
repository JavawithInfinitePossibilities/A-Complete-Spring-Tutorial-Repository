/**
 * 
 */
package com.tutorials.sid.spring.services.impl;


import com.tutorials.sid.spring.model.db.DoctorDetails;
import com.tutorials.sid.spring.repositories.DoctorRepo;
import com.tutorials.sid.spring.services.IDoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lenovo
 *
 */
@Service
@Transactional
public class DoctorServiceImpl implements IDoctorServices {

	@Autowired
	private DoctorRepo doctorRepo;

	
	@Override
	public DoctorDetails save(DoctorDetails doctorDetails) {
		return doctorRepo.save(doctorDetails);
	}

	@Override
	public DoctorDetails get(int doctorId) {
		return doctorRepo.findById(doctorId).get();
	}

	@Override
	public DoctorDetails getDoctorByName(String firstName) {
		return doctorRepo.getDoctorDetailsByFirstName(firstName);
	}

	@Override
	public DoctorDetails update(DoctorDetails doctorDetails) {
		return doctorRepo.save(doctorDetails);
	}

}
