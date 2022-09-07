/**
 * 
 */
package com.tutorials.sid.spring.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo  /** To access a static method we use the 'T' in the Expression
 *         language.<br/>
 *         But when you want to use a object and its instance method just
 *         declare a 'new' keyword and then '.' then method.<br/>
 *         To use any static property then use 'T' and the class name and then
 *         the property.Below is the example<br/>
 *         #{T(java.lang.Math).abs(-120)}}<br/>
 *         To access the instance property below <br/>
 *         below is the example<br/>
 *         #{new
 *         com.tutorials.spring.util.GenerationRandomNumber().randomProperty}
 */

@Component
@Scope("prototype")
public class Instructor {
	@Value("#{T(java.lang.Math).random()*10}")
	private int id;
	@Value("Siddhant")
	private String name;
	@Autowired
	private Address address;
	@Value("#{departments}")
	private List<String> departments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getDepartments() {
		return departments;
	}

	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", address=" + address + ", departments=" + departments
				+ "]";
	}

}
