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

import com.tutorials.sid.spring.entities.Product;

@SpringBootTest(classes = Division10HealthCheckandMetrics.class)
class Division10HealthCheckandMetricsTest {

	@Value("${productrestapi.services.url}")
	private String bashURL;

	@Disabled("Disable to make the test cases more visible")
	@Test
	void getAllProduct() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "products/", Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled
	@Test
	void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(bashURL + "productById/1", Product.class);
		System.out.println("product.getName() :" + product);
	}

	@Disabled
	@Test
	void getProductByName() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "productByName/vaporizer",
				Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled
	@Test
	void getProductByNameAndPrice() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> productArr = restTemplate.getForEntity(bashURL + "productByNameAndPrice/Ip&900",
				Product[].class);
		List<Product> products = Arrays.asList(productArr.getBody());
		products.stream().forEach(System.out::println);
	}

	@Disabled
	@Test
	void saveProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product("Apple TV", "TV", 7000);
		Product product2 = restTemplate.postForObject(bashURL + "productSave/", product, Product.class);
		System.out.println("product.getName() :" + product2.getName());
	}

	@Test
	void updateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(bashURL + "productById/5", Product.class);
		System.out.println("product.getName() :" + product.getName());
		product.setPrice(2000);
		restTemplate.put(bashURL + "productUpdate/", product);
	}

}
