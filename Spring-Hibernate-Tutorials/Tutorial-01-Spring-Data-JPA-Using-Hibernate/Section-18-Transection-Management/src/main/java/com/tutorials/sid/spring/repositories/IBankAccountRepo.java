/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IBankAccountRepo extends CrudRepository<BankAccount, Integer> {

}
