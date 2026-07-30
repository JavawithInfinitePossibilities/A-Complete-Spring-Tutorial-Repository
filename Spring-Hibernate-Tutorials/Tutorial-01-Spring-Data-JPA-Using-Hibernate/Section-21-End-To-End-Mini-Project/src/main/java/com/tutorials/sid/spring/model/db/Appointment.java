/**
 * 
 */
package com.tutorials.sid.spring.model.db;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "appointment_time")
	private Timestamp appointmentTime;
	private boolean start;
	private boolean end;
	private String reason;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private PatientDetails patientDetails;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private DoctorDetails doctorDetails;

	/**
	 * @param appointmentTime
	 * @param strat
	 * @param end
	 * @param reason
	 */
	@Builder
	public Appointment(Timestamp appointmentTime, boolean start, boolean end, String reason) {
		super();
		this.appointmentTime = appointmentTime;
		this.start = start;
		this.end = end;
		this.reason = reason;
	}
}
