/**
 * 
 */
package com.tutorials.sid.spring.dao.productdao;

import java.util.List;

import com.tutorials.sid.spring.module.Product;

/**
 * @author Lenovo
 *
 */
public interface IProductDAO {

	public int create(Product product);

	public void update(Product product);

	public void delete(int id);

	public List<Product> getProducts(String productName);

	public List<Product> loadAllProduct();

}
