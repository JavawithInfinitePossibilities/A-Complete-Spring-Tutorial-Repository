/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author kunmu
 *
 */
public interface IProductMogRepo extends MongoRepository<Product, String> {

}
