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
public class TestUsingPropertyFile {

	@Autowired
	ApplicationContext context;

	@Test
	public void testInnerbeanAndScope() {
		MyDBO dbo = (MyDBO) context.getBean("myDBO");
		System.out.println("dbo detial : " + dbo);
	}
}
