/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorials.sid.spring.bean.intf.IOrderBAO;

/**
 * @author Lenovo
 *
 */
public class Chapter13InjectingInterfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
		IOrderBAO orderBAO = (IOrderBAO) context.getBean("orderBAOImpl");
		orderBAO.order();
	}

}
