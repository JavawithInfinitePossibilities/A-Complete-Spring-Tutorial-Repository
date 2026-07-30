package com.tutorials.sid.spring.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Integer age;
}
