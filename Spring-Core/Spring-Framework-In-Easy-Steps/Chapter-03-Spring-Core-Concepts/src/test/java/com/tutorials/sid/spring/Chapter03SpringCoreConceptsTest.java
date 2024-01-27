package com.tutorials.sid.spring;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.sid.spring.bean.SpringCoreBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class Chapter03SpringCoreConceptsTest {

	@Autowired
	ApplicationContext context;
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testCore() {
		SpringCoreBean bean = (SpringCoreBean) context.getBean("springCoreBean");
		System.out.println("Bean description: " + bean);
		SpringCoreBean bean1 = (SpringCoreBean) context.getBean("employee");
		System.out.println("Bean description: " + bean1);
		SpringCoreBean bean2 = (SpringCoreBean) context.getBean("emp");
		System.out.println("Bean description: " + bean2);
	}
}
