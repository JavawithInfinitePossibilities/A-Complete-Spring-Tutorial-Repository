package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.model.Vaccine;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author kunmu On 26-07-2026
 */
@Service
public class VaccineConsumer implements Consumer<Vaccine> {
    @Override
    public void accept(Vaccine vaccine) {
        System.out.println("Vaccine received: " + vaccine);
    }
}
