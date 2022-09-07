package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.services.IPaymentServices;

@SpringBootTest(classes = Division04FirstProject.class)
class Division04FirstProjectTest {

	@Autowired
	IPaymentServices iPaymentServices;

	@Disabled
	@Test
	void test() {
	}

	@Disabled
	@Test
	void testCreate() {
		iPaymentServices.create();
	}

	@Disabled
	@Test
	void testUpdate() {
		iPaymentServices.update();
	}

	@Disabled
	@Test
	void testDelete() {
		iPaymentServices.delete();
	}

	@Test
	void testSelect() {
		iPaymentServices.get();
	}

}
