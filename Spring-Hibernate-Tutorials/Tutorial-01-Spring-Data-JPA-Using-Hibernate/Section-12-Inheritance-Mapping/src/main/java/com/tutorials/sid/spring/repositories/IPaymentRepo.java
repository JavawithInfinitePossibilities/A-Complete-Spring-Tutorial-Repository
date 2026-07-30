/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.db.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IPaymentRepo extends CrudRepository<Payment, Integer> {

}
