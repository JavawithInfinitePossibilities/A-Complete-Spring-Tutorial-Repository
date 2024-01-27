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

import com.tutorials.sid.spring.bean.xml.Employee;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestAutowireXMLByTypeAmbiguity {

	@Autowired
	ApplicationContext context;

	/*Unsatisfied dependency expressed through bean property 'address'; 
	nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	No qualifying bean of type 'com.tutorials.spring.Section9AutoWiring.xml.bean.Address' available: 
	expected single matching bean but found 2: address,address1
	*/
	@Test
	public void testAutowireXMLByTypeAmbiguity() {
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee);
	}
}
