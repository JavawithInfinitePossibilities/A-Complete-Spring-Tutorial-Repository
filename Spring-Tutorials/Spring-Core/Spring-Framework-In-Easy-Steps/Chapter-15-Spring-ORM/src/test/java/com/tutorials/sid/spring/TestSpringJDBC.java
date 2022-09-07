/**
 * 
 */
package com.tutorials.sid.spring;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.sid.spring.entity.Product;
import com.tutorials.sid.spring.productDAO.ProductDaoImpl;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestSpringJDBC {

	@Autowired
	ApplicationContext context;

	@Test
	public void testSpringJDBCAnnotationConfigSave() {
		Product product = (Product) context.getBean("product");
		System.out.println("Product detial : " + product);
		ProductDaoImpl productDaoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
		int productCreate = productDaoImpl.create(product);
		System.out.println("Total product Created :" + productCreate);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigUpdate() {
		ProductDaoImpl productDaoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
		Product product = productDaoImpl.getProduct(1);
		System.out.println("Total product Created :" + product);
		product.setDescription("M-SUV");
		productDaoImpl.update(product);
		System.out.println("Total product Created :" + product);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigDelete() {
		ProductDaoImpl productDaoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
		productDaoImpl.delete(1);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigSelect() {
		ProductDaoImpl productDaoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
		Product product = productDaoImpl.getProduct(2);
		System.out.println("Total product Created :" + product);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigSelectList() {
		ProductDaoImpl productDaoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
		List<Product> product = productDaoImpl.loadAllProduct();
		System.out.println("Total product Created :" + product);
	}
}
