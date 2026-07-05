/**
 * 
 */
package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.dto.Coupon;
import com.tutorials.sid.spring.model.Product;
import com.tutorials.sid.spring.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author kunmu <br/>
 *         URL:
 *         http://localhost:8080/Section-04-Create-Microservices-productservices/productapi/getproduct/1
 *         http://localhost:8080/Section-04-Create-Microservices-productservices/productapi/saveproduct
 *         {
 *     			"id": 1,
 *     			"name": "Ipad",
 *     			"description": "tablet",
 *     			"price": 1000.00,
 *     			"couponCode": "SUPERSEAL202608"
 * 			}
 *
 */
@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Value("${couponservices.uri}")
	private String couponServices;

	@Autowired
	private ProductRepositories productRepositories;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServices + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepositories.save(product);
	}

	@RequestMapping(value = "/getproduct/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("productId") Long productId) {
		Product product = productRepositories.findById(productId).get();
		return product;
	}

}
