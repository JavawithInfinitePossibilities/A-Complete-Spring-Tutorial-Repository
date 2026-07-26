package com.tutorials.sid.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 26-07-2026
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientData {
    private String heartRate;
    private String bloodPressure;
}
