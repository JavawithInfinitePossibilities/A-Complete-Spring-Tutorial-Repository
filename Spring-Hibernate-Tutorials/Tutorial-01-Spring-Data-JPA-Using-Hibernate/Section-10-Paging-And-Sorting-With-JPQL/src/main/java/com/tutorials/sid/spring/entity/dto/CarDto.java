package com.tutorials.sid.spring.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 10-02-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CarDto {
    private Integer id;
    private String make;
    private String model;
    private String color;
}
