/**
 * 
 */
package com.tutorials.sid.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.sid.spring.bean.Employee;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestAutowireByAnnotationConstructor {

	@Autowired
	ApplicationContext context;

	@Test
	public void testAutowireXMLByType() {
		Employee employee = (Employee) context.getBean("employeeAutowireByAnnotationConstructor");
		System.out.println("Employee detial : " + employee);
	}
}
