/**
 * 
 */
package com.tutorials.sid.spring.model;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String description;
	private double price;

	/**
	 * @param name
	 * @param description
	 * @param price
	 */
	public Product(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

}

