/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.db.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

}
