/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorials.sid.spring.bean.Instructor;

/**
 * @author Lenovo
 *
 */
public class Chapter11StereotypeAnnotations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
		Instructor instructor = (Instructor) context.getBean("instructor");
		System.out.println("Instructor detial : " + instructor);
		
		Instructor instructor1 = (Instructor) context.getBean("instructor");
		System.out.println("Instructor detial : " + instructor1);
		
		System.out.println("Instructor hashCode detial : " + instructor.hashCode());
		System.out.println("Instructor-1 hashCode detial : " + instructor1.hashCode());
	}

}
