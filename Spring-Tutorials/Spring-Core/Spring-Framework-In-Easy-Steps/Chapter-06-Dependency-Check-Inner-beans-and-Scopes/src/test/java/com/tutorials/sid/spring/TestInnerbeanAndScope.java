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

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestInnerbeanAndScope {

	@Autowired
	ApplicationContext context;

	@Test
	public void testInnerbeanAndScope() {
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee);
		System.out.println("Employee detial : " + employee.hashCode());

		Employee employee2 = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee2.hashCode());
	}
}
