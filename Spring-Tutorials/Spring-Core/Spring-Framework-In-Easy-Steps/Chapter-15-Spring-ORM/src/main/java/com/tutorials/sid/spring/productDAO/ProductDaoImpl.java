/**
 * 
 */
package com.tutorials.sid.spring.productDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tutorials.sid.spring.entity.Product;

/**
 * @author Lenovo
 *
 */
@Component
public class ProductDaoImpl implements IProductDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
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

	@SuppressWarnings("deprecation")
	@Override
	public Product getProduct(int id) {
		Product product = hibernateTemplate.get(Product.class, new Integer(id));
		return product;
	}

	@Override
	public List<Product> loadAllProduct() {
		return hibernateTemplate.loadAll(Product.class);
	}

}
