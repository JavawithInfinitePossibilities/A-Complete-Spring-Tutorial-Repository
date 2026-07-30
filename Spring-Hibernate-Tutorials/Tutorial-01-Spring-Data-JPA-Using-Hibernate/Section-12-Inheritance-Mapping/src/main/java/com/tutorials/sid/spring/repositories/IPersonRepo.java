/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.db.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IPersonRepo extends CrudRepository<Person, Integer> {

}
