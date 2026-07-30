/**
 * 
 */
package com.tutorials.sid.spring.services;


import com.tutorials.sid.spring.model.db.DoctorDetails;

/**
 * @author Lenovo
 *
 */
public interface IDoctorServices {

	public DoctorDetails save(DoctorDetails doctorDetails);

	public DoctorDetails get(int doctorId);

	public DoctorDetails getDoctorByName(String firstName);

	public DoctorDetails update(DoctorDetails doctorDetails);
}
