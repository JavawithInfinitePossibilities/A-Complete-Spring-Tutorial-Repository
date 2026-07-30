/**
 * 
 */
package com.tutorials.sid.spring.services;


import com.tutorials.sid.spring.entity.BankAccount;

/**
 * @author Lenovo
 *
 */
public interface IBankAccountService {
	public BankAccount save(BankAccount account);

	public void transactionAccount(BankAccount from, BankAccount to, int substract);
}
