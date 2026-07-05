/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kunmu
 *
 */
public interface ProductRepositories extends JpaRepository<Product, Long> {

}
