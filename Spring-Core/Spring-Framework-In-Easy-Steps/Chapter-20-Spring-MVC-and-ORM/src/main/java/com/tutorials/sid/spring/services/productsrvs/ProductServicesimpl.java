/**
 * 
 */
package com.tutorials.sid.spring.services.productsrvs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorials.sid.spring.dao.productdao.IProductDAO;
import com.tutorials.sid.spring.module.Product;

/**
 * @author Lenovo
 *
 */
@Service
public class ProductServicesimpl implements IProductServices {

	@Autowired
	@Qualifier("productDaoImpl")
	private IProductDAO productDao;

	@Override
	@Transactional
	public int create(String name, String description, double price) {
		return productDao.create(new Product(name, description, price));
	}

	@Override
	public List<Product> loadAllProduct() {
		return productDao.loadAllProduct();
	}

	@Override
	public List<Product> getProduct(String productName) {
		return productDao.getProducts(productName);
	}

}
