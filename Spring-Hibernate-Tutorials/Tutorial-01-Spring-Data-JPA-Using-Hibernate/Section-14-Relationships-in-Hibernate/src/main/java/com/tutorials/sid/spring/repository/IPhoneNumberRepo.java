/**
 * 
 */
package com.tutorials.sid.spring.repository;


import com.tutorials.sid.spring.entity.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lenovo
 *
 */
@Repository
public interface IPhoneNumberRepo extends CrudRepository<PhoneNumber, Integer> {

}
