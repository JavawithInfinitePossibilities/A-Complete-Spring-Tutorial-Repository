/**
 * 
 */
package com.tutorials.sid.spring.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

/**
 * @author Lenovo
 *
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "studentdb")
public class StudentDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "fname")
	private String name;
	@Column(name = "test_score")
	private int testScore;

}

