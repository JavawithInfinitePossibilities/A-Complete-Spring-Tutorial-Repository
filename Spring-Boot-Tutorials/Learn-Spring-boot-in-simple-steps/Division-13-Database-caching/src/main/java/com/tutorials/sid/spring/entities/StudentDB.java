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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */
@Entity(name = "studentdb")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "fname")
	private String name;
	@Column(name = "test_score")
	private int testScore;

	@Override
	public String toString() {
		return "StudentDB [id=" + id + ", name=" + name + ", testScore=" + testScore + "]";
	}

}

