/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorials.sid.spring.bean.Employee;

/**
 * @author Lenovo
 *
 */
public class Chapter12SpringExpressionLanguage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee);
		
		Employee employee1 = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee1);
		
		System.out.println("Employee hashCode detial : " + employee.hashCode());
		System.out.println("Employee-1 hashCode detial : " + employee1.hashCode());
	}

}
