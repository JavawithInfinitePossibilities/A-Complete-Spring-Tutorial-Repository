/**
 * 
 */
package com.tutorials.sid.spring.services.impl;


import com.tutorials.sid.spring.model.db.Appointment;
import com.tutorials.sid.spring.repositories.AppointmentRepo;
import com.tutorials.sid.spring.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lenovo
 *
 */
@Service
@Transactional
public class AppointmentServicesImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Override
	public Appointment save(Appointment doctorDetails) {
		return appointmentRepo.save(doctorDetails);
	}

	@Override
	public Appointment get(int appointmentId) {
		return appointmentRepo.findById(appointmentId).get();
	}

	@Override
	public Appointment update(Appointment doctorDetails) {
		return appointmentRepo.save(doctorDetails);
	}

}
