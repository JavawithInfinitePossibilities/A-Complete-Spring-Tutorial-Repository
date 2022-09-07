package com.tutorials.sid.spring.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
	private String id;
	private String title;
	private String description;
	private List<Question> questions;

}