/**
 * 
 */
package com.tutorials.sid.spring.dao.productdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tutorials.sid.spring.module.Product;

/**
 * @author Lenovo
 *
 */
@Component
public class ProductDaoImpl implements IProductDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int create(Product product) {
		Integer result = (Integer) hibernateTemplate.save(product);
		return result;
	}

	@Override
	@Transactional
	public void update(Product product) {
		hibernateTemplate.update(product);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void delete(int id) {
		Product product = hibernateTemplate.get(Product.class, new Integer(id));
		hibernateTemplate.delete(product);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Product> getProducts(String productName) {
		String queryString="from Product where product_name=:productName";
		List<Product> products = (List<Product>) hibernateTemplate.findByNamedParam(queryString, "productName", productName);
		return products;
	}

	@Override
	public List<Product> loadAllProduct() {
		return hibernateTemplate.loadAll(Product.class);
	}

}
