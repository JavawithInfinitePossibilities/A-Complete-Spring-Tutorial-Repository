/**
 * 
 */
package com.tutorials.sid.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class Employee {
	@Value("#{T(java.lang.Math).random()*10}")
	private int id;
	@Value("Sid")
	private String firstName;
	@Value("Sahu")
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
