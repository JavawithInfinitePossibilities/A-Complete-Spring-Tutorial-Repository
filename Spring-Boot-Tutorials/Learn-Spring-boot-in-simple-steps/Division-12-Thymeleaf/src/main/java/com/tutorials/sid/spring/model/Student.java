/**
 * 
 */
package com.tutorials.sid.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {

	private int id;
	private String name;
	private double score;
}

