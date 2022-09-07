package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.services.BinarySearchImpl;

@SpringBootTest(classes = Section03IntroductiontoSpringFrameworkin10Steps.class)
class Section03IntroductiontoSpringFrameworkin10StepsTest {
	@Autowired
	BinarySearchImpl binarySearchImpl;

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testDependency() {
		assertNotNull(binarySearchImpl);
	}

}
