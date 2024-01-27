package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.Services.MyMath;

@SpringBootTest(classes = Section03IntroductiontoJUnitin5Steps.class)
class Section03IntroductiontoJUnitin5StepsTest {

	@Autowired
	MyMath myMath;

	@BeforeEach
	public void beforeUnitTest() {
		System.out.println("Before every test case");
	}

	@BeforeAll
	public static void beforeAllUnitTest() {
		System.out.println("Before all every test case. This is a static method which is related to class level.");
	}

	@Test
	void test() {
		int sum = myMath.sum(1, 2, 3);
		System.out.println("Sum is : " + sum);
		assertEquals(6, 6);
	}

	@Test
	void test1() {
		int sum = myMath.sum(1, 2, 3);
		System.out.println("Sum is : " + sum);
		assertEquals(6, 6);
	}

	@AfterEach
	public void afterUnitTest() {
		System.out.println("after every test case");
	}

	@AfterAll
	public static void afterAllUnitTest() {
		System.out.println("After all every test case. This is a static method which is related to class level.");
	}
}
