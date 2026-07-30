/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.componentMapping.CustomerId;
import com.tutorials.sid.spring.model.db.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface ICustomerRepo extends CrudRepository<Customer, CustomerId> {

}
