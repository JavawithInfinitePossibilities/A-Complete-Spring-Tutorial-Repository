package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.repository.IPaymentDAO;
import com.tutorials.sid.spring.services.IPaymentServices;
import com.tutorials.sid.spring.services.impl.PaymentServices;

@SpringBootTest(classes = Section04IntroductiontoMockitoin5Steps.class)
class Section04IntroductiontoMockitoin5StepsTest {

	@Autowired
	static IPaymentServices services;

	@BeforeAll
	public static void initialaition() {
		services = getPayment();
	}

	public static IPaymentServices getPayment() {
		IPaymentDAO paymentDAO = mock(IPaymentDAO.class);
		when(paymentDAO.get()).thenReturn("This is a mock test unit");
		IPaymentServices services = new PaymentServices(paymentDAO);
		return services;
	}

	@Test
	void test() {
		String value = services.get();
		assertEquals("This is a mock test unit", value);
	}

}
