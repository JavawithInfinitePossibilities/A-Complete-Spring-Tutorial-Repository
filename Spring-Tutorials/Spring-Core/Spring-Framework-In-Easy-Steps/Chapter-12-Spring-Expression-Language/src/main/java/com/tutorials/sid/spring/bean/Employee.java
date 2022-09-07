/**
 * 
 */
package com.tutorials.sid.spring.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class Employee {
	/**
	 * To access a static method we use the 'T' in the Expression language.<br/>
	 * But when you want to use a object and its instance method just declare a
	 * 'new' keyword and then '.' then method.<br/>
	 * To use any static property then use 'T' and the class name and then the
	 * property.Below is the example<br/>
	 * #{T(java.lang.Math).abs(-120)}}<br/>
	 * To access the instance property below <br/>
	 * below is the example<br/>
	 * #{new com.tutorials.spring.util.GenerationRandomNumber().randomProperty}
	 */
	/*@Value("#{T(com.tutorials.spring.util.GenerationRandomNumber).genratingRandomNumberByRandomClass(120)}")*/
	@Value("#{new java.util.Random().nextInt(120)}")
	private int id;
	@Value("#{new java.lang.String('Siddhant Sahu')}")
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
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", departments=" + departments + "]";
	}

}
