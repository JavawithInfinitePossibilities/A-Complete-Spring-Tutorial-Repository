package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.model.ClientData;
import com.tutorials.sid.spring.model.Patient;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

/**
 * @author kunmu On 26-07-2026
 */
@Controller
public class RSocketPatientController {

    @MessageMapping("get-patient-data")
    private Mono<ClientData> getClinicalData(@RequestBody Patient patient) {
        // Implement the logic to retrieve a patient by ID
        System.out.println("Clinical data requested for patient server: " + patient);
        return Mono.just(new ClientData("72", "120/80"));
    }

    @MessageMapping("patient-checkout")
    private Mono<Void> fireAndForgetClinicalData() {
        // Implement the logic to retrieve a patient by ID
        System.out.println("Patient checkout requested for patient server: ");
        return Mono.empty().then();
    }
}
