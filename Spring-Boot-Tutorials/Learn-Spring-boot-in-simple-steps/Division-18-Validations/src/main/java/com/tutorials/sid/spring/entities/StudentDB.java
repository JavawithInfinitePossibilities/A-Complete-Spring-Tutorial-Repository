/**
 * 
 */
package com.tutorials.sid.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
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
	@Size(min = 10, max = 20, message = "Name should be between 10 and 20 characters")
	@Column(name = "fname")
	private String name;
	@Column(name = "test_score")
	@Min(value = 0, message = "Test score should be greater than or equal to 0")
	@Max(value = 100, message = "Test score should be less than or equal to 100")
	private int testScore;

}

