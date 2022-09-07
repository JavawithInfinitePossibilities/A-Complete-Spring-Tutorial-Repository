/**
 * 
 */
package com.tutorials.sid.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.sid.spring.model.db.Product;
import com.tutorials.sid.spring.model.dto.Coupon;
import com.tutorials.sid.spring.repo.IProductRepo;
import com.tutorials.sid.spring.restclient.IFeignCouponClient;

import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Lenovo URL :
 *         http://localhost:9090/productcart/productdetails/products/
 *         http://localhost:9090/productcart/productdetails/getprop
 *         http://localhost:9090/productcart/productdetails/productById/2
 *         http://localhost:9090/productcart/productdetails/productSave/
 *         http://localhost:8765/product-services/productcart/productdetails/productSave/
 *         Input JSON:<br/>
 *         { "id": 2, "name": "Iphone", "description": "Iphone Apple", "price":
 *         1200.0, "couponCode": "SUPERSEAL2021" }
 *
 */
@RestController
@RequestMapping(value = "/productdetails")
@RefreshScope
public class ProductRESTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRESTController.class);

	@Autowired
	private IProductRepo productRepository;

	@Autowired
	private IFeignCouponClient iFeignCouponClient;

	@Value("${com.sid.tutorial.springboot.cloud.custom.prop}")
	private String myCustomProperty;

	@RequestMapping(value = "/products/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/productById/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding product by id : " + id);
		return productRepository.findById(id).get();
	}

	@RequestMapping(value = "/productByName/{name}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	public List<Product> getProductByName(@PathVariable("name") String name) {
		LOGGER.info("Finding product by name : " + name);
		return productRepository.findByName(name);
	}

	@RequestMapping(value = "/productByNameAndPrice/{name}&{price}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	public List<Product> getProductByNameAndPrice(@PathVariable("name") String name,
			@PathVariable("price") double price) {
		LOGGER.info("Finding product by name : " + name + " and Price :" + price);
		return productRepository.findByNameLikeAndPrice(name, price);
	}

	@RequestMapping(value = "/productSave/", method = RequestMethod.POST)
	@Retry(name = "product-api-retry", fallbackMethod = "sendErrorResponse")
	public Product createProduct(@RequestBody Product product) {
		Coupon coupon = iFeignCouponClient.getCoupon(product.getCouponCode());
		double price = product.getPrice() * (coupon.getDiscount().doubleValue() / 100);
		System.out.println(coupon + "  : price discount: " + price);
		product.setPrice(product.getPrice() - price);
		return productRepository.save(product);
	}

	public Product sendErrorResponse(Product product, Exception exception) {
		System.out.println("Error while connecting to coupon services" + exception);
		return product;
	}

	@RequestMapping(value = "/getprop/", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public String getProp() {
		return myCustomProperty;
	}

	@RequestMapping(value = "/productUpdate/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/productDelete/{id}", method = RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}
}
