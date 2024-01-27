package com.tutorials.sid.spring;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorials.sid.spring.annotationconfig.Patient;
/*import com.tutorials.sid.spring.interfaceconfig.Patient;*/
/*import com.tutorials.sid.spring.xmlconfig.Patient;*/



public class Chapter05LifeCycleMethodsAppTest {

	@Test
	public void test() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/Spring-Config.xml");
		/*Patient patient = (Patient) context.getBean("patientXml");*/
		/*Patient patient = (Patient) context.getBean("patientInterface");*/
		Patient patient = (Patient) context.getBean("patientAnnotation");
		System.out.println("Patient detial : " + patient);
		context.registerShutdownHook();
	}

}
