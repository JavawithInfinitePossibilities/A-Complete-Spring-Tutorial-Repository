/**
 * 
 */
package com.tutorials.sid.spring.module.dto;

import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class ProductDto {

	private String name;
	private String description;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
	}

}
