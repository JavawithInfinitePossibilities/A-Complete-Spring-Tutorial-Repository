/**
 * 
 */
package com.tutorials.sid.spring.xmlconfig;

/**
 * @author Lenovo
 *
 */
public class Patient {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("This is the setter method");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

	public void init() {
		System.out.println("This is Patient XML init method.");
	}

	public void destory() {
		System.out.println("This is Patient XML destory method.");
	}
}
