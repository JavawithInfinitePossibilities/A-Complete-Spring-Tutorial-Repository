package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.services.VaccineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

/**
 * @author kunmu On 26-07-2026
 * URL: http://localhost:8080/vaccines
 * In netty context path is not required or not working.
 */
@Controller
public class VaccineController {
    @Autowired
    private VaccineServices vaccineServices;

    @GetMapping("/vaccines")
    public Mono<String> getAllVaccines(Model model) {
        model.addAttribute("vaccines", vaccineServices.getAllVaccines());
        return Mono.just("index");
    }
}
