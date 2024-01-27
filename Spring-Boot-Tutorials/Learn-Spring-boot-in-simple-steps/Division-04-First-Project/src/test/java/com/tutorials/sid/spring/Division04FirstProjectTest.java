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

	@Test
	void test() {
		assertNotNull(iPaymentServices, "Value is not null!!!");
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

	@Disabled
	@Test
	void testSelect() {
		iPaymentServices.get();
	}

}
