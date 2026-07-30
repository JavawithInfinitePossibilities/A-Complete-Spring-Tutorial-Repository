package com.tutorials.sid.spring.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author kunmu On 10-02-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PersonDto implements Serializable {
    private String firstName;
    private String lastName;
}




