package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.sender.JmsMessageSender;

@SpringBootTest(classes = Division16MessagingandSpringJMS.class)
class Division16MessagingandSpringJMSTest {

	@Autowired
	private JmsMessageSender sender;

	@Test
	void jmsSendAndReceive() {
		sender.send("Hi this is JMS message!!!");
	}

}
