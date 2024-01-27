/**
 * 
 */
package com.tutorials.sid.spring.interfaceconfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Lenovo
 *
 */
public class Patient implements InitializingBean, DisposableBean {

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
		System.out.println("This is Patient init method.");
	}

	public void destory() {
		System.out.println("This is Patient destory-method.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This is Patient afterPropertiesSet method. This is the current class : " + this.id);

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("This is Patient destory method.");
	}
}
