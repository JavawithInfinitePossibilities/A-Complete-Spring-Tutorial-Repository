/**
 * 
 */
package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lenovo
 *
 */
@Repository
public interface IClientRepo extends CrudRepository<Client, Integer> {

}
