package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "make_description")
    private String make;
    private String model;
    private String color;
    private Integer year;
    private Double price;
}
