/**
 * 
 */
package com.tutorials.sid.spring.repository;


import com.tutorials.sid.spring.entity.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IDriverRepo extends CrudRepository<Driver, Integer> {

}
