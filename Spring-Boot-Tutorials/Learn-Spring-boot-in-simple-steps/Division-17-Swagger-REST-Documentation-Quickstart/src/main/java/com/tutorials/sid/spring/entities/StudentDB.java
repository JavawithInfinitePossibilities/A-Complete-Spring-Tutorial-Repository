/**
 * 
 */
package com.tutorials.sid.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fname")
	private String name;
	@Column(name = "test_score")
	private int testScore;

}

