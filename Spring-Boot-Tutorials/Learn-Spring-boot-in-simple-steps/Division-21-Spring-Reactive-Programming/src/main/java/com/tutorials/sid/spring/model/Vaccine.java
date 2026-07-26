package com.tutorials.sid.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 26-07-2026
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Vaccine {
    private String name;
    private String manufacturer;
    private boolean delivered;
}
