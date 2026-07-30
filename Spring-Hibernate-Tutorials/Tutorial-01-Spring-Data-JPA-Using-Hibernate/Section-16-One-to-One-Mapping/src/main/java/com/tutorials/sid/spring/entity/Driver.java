/**
 * 
 */
package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@ToString(exclude = "license")
@NoArgsConstructor
@Entity
public class Driver implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private int driverId;
	private String firstName;
	private String lastName;
	private int age;

	@OneToOne(mappedBy = "driver")
	private License license;

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param license
	 */
	@Builder
	public Driver(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}

