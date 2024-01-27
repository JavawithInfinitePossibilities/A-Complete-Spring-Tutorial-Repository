/**
 * 
 */
package com.tutorials.sid.spring.bean;

/**
 * @author Lenovo
 *
 */
public class SpringCoreBean {
	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "SpringCoreBean [id=" + id + ", name=" + name + "]";
	}
}
