package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link Product}.
 *
 * Inherits from JpaRepository:
 *   - findAll()        → used by home page
 *   - findById(Long)   → used by search and result page
 *   - save(Product)    → used by save form
 */
public interface ProductRepositories extends JpaRepository<Product, Long> {
    // No custom queries needed — JpaRepository covers all required operations.
}
