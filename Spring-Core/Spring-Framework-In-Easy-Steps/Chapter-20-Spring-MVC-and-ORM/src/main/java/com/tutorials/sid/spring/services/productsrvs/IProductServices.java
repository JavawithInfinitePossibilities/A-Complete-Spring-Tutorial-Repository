/**
 * 
 */
package com.tutorials.sid.spring.services.productsrvs;

import java.util.List;

import com.tutorials.sid.spring.module.Product;

/**
 * @author Lenovo
 *
 */
public interface IProductServices {

	public int create(String name, String description, double price);

	public List<Product> loadAllProduct();
	
	public List<Product> getProduct(String productName);
}
