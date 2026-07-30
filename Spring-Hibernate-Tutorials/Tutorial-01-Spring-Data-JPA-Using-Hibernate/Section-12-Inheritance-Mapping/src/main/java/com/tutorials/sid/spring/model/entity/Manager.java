/**
 * 
 */
package com.tutorials.sid.spring.model.entity;

import com.tutorials.sid.spring.model.db.Person;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Manager extends Person {

	private String employeeNumber;

	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 */
	@Builder
	public Manager(String firstName, String lastName, String employeeNumber) {
		super(firstName, lastName);
		this.employeeNumber = employeeNumber;
	}

}
