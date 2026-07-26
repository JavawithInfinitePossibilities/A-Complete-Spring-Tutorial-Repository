package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.model.ClientData;
import com.tutorials.sid.spring.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author kunmu On 26-07-2026
 * URL:http://localhost:8090/patient/clinicalData
 * Body: {"firstName":"John","lastName":"Doe","ssn":"123-45-6789"}
 * http://localhost:8090/fire-and-forget
 */
@RestController
public class RSocketPatientClientController {
    private final RSocketRequester requester;

    public RSocketPatientClientController(@Autowired RSocketRequester.Builder builder) {
        this.requester = builder.tcp("localhost", 7000);
    }

    @GetMapping("/patient/clinicalData")
    public Mono<ClientData> getClinicalData(@RequestBody Patient patient) {
        System.out.println("Requesting clinical data for patient in client: " + patient);
        return requester.route("get-patient-data").data(patient).retrieveMono(ClientData.class);
    }

    @GetMapping("/fire-and-forget")
    public Mono<Void> fireAndForgetClientData() {
        System.out.println("Firing and forgetting patient checkout for patient in client: ");
        return requester.route("patient-checkout").retrieveMono(Void.class);
    }
}
