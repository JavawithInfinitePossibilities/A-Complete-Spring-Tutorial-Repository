package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.model.Vaccine;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author kunmu On 26-07-2026
 */
@Service
public class VaccineServices {

    public Flux<Vaccine> getAllVaccines() {
        return Flux.just(
                new Vaccine("Covaxin", "Bharat Biotech", false),
                new Vaccine("Covishield", "Serum Institute of India", false),
                new Vaccine("Sputnik V", "Gamaleya Research Institute", false),
                new Vaccine("Moderna", "Moderna, Inc.", false),
                new Vaccine("Pfizer-BioNTech", "Pfizer, Inc. and BioNTech SE", false)
        );
    }
}
