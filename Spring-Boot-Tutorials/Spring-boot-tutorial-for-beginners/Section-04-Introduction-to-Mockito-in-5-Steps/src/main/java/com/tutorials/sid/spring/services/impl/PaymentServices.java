/**
 * 
 */
package com.tutorials.sid.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorials.sid.spring.repository.IPaymentDAO;
import com.tutorials.sid.spring.services.IPaymentServices;

/**
 * @author Lenovo
 *
 */
@Service
public class PaymentServices implements IPaymentServices {

	@Autowired
	private IPaymentDAO paymentDAO;

	public PaymentServices(IPaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public IPaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	public void setPaymentDAO(IPaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	@Override
	public void create() {
		paymentDAO.save();
	}

	@Override
	public void update() {
		paymentDAO.update();
	}

	@Override
	public void delete() {
		paymentDAO.delete();
	}

	@Override
	public String get() {
		return paymentDAO.get();
	}

}
