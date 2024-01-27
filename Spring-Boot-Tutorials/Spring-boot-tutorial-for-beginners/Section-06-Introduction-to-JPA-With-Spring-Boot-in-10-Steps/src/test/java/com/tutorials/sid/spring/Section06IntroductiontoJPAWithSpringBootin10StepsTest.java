package com.tutorials.sid.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tutorials.sid.spring.entities.StudentDB;

@SpringBootTest(classes = Section06IntroductiontoJPAWithSpringBootin10Steps.class)
class Section06IntroductiontoJPAWithSpringBootin10StepsTest {

	@Value("${productrestapi.services.url}")
	private String bashURL;

	//@Disabled("Disable to make the test cases more visible")
	@Test
	void getAllProduct() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StudentDB[]> productArr = restTemplate.getForEntity(bashURL + "Students/", StudentDB[].class);
		List<StudentDB> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}
}
