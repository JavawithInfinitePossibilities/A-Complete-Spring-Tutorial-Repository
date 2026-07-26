package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author kunmu On 26-07-2026
 */
@Service
public class VaccineProvider {

    @Autowired
    private VaccineServices vaccineServices;

    public Flux<Vaccine> getAllVaccines() {
        return vaccineServices.getAllVaccines().map(this::setDeliveredStatus);
    }

    private Vaccine setDeliveredStatus(Vaccine vaccine) {
        vaccine.setDelivered(true);
        return vaccine;
    }
}
