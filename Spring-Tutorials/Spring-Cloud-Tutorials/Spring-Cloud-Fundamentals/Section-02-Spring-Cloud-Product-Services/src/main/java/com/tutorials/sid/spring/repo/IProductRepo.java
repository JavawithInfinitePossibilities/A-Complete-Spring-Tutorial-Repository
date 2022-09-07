/**
 * 
 */
package com.tutorials.sid.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorials.sid.spring.model.db.Product;

/**
 * @author Lenovo
 *
 */
public interface IProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByNameLikeAndPrice(String name, double price);

}
