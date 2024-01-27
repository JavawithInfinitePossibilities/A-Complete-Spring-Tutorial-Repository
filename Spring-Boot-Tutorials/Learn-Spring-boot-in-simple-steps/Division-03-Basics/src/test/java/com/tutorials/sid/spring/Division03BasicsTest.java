package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Division03Basics.class)
class Division03BasicsTest {

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void contextLoads() {
		System.out.println("Welcome to spring boot tutorials...");
	}

}
