package com.tutorials.sid.spring;


import com.tutorials.sid.spring.model.db.Appointment;
import com.tutorials.sid.spring.model.db.DoctorDetails;
import com.tutorials.sid.spring.model.db.PatientDetails;
import com.tutorials.sid.spring.model.dto.Insurance;
import com.tutorials.sid.spring.services.IAppointmentService;
import com.tutorials.sid.spring.services.IDoctorServices;
import com.tutorials.sid.spring.services.IPatientService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Unit test for simple Section21EndToEndMiniProject.
 */
@SpringBootTest(classes = Section21EndToEndMiniProject.class)
public class Section21EndToEndMiniProjectTest {

    Random random = new Random();

    @Autowired
    private IDoctorServices iDoctorServices;

    @Autowired
    private IPatientService iPatientService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Test
    public void testApp() {
    }

    @Disabled
    @Test
    void testLoadDoctor() {
        int count = 2;
        while (count < 6) {
            count++;
            DoctorDetails doctorDetails = DoctorDetails.builder().firstName("Doctor-First-" + random.nextInt(10))
                    .lastName("Doctor-last-" + random.nextInt(10)).specility("Doctor-Specility-" + random.nextInt(10))
                    .build();
            iDoctorServices.save(doctorDetails);
        }
    }

    @Disabled
    @Test
    public void testLoadPatient() {
        int count = 2;
        while (count < 11) {
            count++;
            Insurance insurance = Insurance.builder().providerName("Insurance-" + random.nextInt(10)).copay(10d)
                    .build();
            PatientDetails patientDetails = PatientDetails.builder()
                    .firstName("Patient-First-" + random.nextInt(10))
                    .lastName("Patient-Last-" + random.nextInt(10))
                    .phone("1230645789")
                    .insurance(insurance)
                    .age(random.nextInt(50)).build();
            /*int doctorNumber = random.nextInt(4);*/
            int doctorNumber=102;
            System.out.println("Doctor number : " + doctorNumber);
            DoctorDetails doctorDetail;
            if (doctorNumber > 0) {
                doctorDetail = iDoctorServices.get(doctorNumber);
            } else {
                doctorNumber = 2;
                doctorDetail = iDoctorServices.get(doctorNumber);
            }
            Set<DoctorDetails> doctorDetails = new HashSet<DoctorDetails>();
            doctorDetails.add(doctorDetail);
            patientDetails.setDoctorDetails(doctorDetails);
            iPatientService.save(patientDetails);
        }
    }

    @Test
    public void testLoadAppointment() throws ParseException {
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        Appointment appointment = Appointment.builder().appointmentTime(date).start(true).end(true)
                .reason("cardiac arrest").build();
        DoctorDetails doctorDetail = iDoctorServices.get(102);
        PatientDetails patientDetails = iPatientService.get(307);

        appointment.setDoctorDetails(doctorDetail);
        appointment.setPatientDetails(patientDetails);
        iAppointmentService.save(appointment);
    }
}
