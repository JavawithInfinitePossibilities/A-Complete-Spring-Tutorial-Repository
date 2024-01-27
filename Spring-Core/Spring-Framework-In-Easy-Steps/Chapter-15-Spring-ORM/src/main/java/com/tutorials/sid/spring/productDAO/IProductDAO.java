/**
 * 
 */
package com.tutorials.sid.spring.productDAO;

import java.util.List;

import com.tutorials.sid.spring.entity.Product;

/**
 * @author Lenovo
 *
 */
public interface IProductDAO {

	public int create(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product getProduct(int id);

	public List<Product> loadAllProduct();

}
