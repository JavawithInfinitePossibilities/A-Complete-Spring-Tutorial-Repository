/**
 * 
 */
package com.tutorials.sid.spring.services;


import com.tutorials.sid.spring.model.db.Appointment;

/**
 * @author Lenovo
 *
 */
public interface IAppointmentService {

	public Appointment save(Appointment doctorDetails);

	public Appointment get(int appointmentId);

	public Appointment update(Appointment doctorDetails);
}
