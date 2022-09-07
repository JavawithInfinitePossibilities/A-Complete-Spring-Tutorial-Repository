package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.repository.IPaymentDAO;
import com.tutorials.sid.spring.services.IPaymentServices;
import com.tutorials.sid.spring.services.impl.PaymentServices;

@SpringBootTest(classes = Section04IntroductiontoMockitoin5Steps.class)
class Section04IntroductiontoMockitoin5StepsTestUsingAnnotation {

	@Mock
	IPaymentDAO paymentDAO;

	/**
	 * org.mockito.exceptions.base.MockitoException: Cannot instantiate @InjectMocks
	 * field named 'services'! Cause: the type 'IPaymentServices' is an interface.
	 * You haven't provided the instance at field declaration so I tried to
	 * construct the instance.<br/>
	 * This is the reason we can't declare a interface at @InjectMocks
	 */

	@InjectMocks
	PaymentServices services;

	@Test
	void test() {
		when(paymentDAO.get()).thenReturn("This is a mock test unit");
		String value = services.get();
		assertEquals("This is a mock test unit", value);
	}

}
