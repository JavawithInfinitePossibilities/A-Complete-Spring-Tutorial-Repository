package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Division01Introduction.class)
class Division01IntroductionTest {

	@Test
	void test() {
		System.out.println("Welcome to spring boot tutorials...");
	}

}
