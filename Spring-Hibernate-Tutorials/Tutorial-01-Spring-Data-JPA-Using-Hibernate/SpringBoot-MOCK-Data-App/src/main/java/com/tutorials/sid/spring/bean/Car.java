package com.tutorials.sid.spring.bean;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car implements Serializable {
	private Integer id;
	private String make;
	private String model;
	private String color;
	private Integer year;
	private Double price;
}
