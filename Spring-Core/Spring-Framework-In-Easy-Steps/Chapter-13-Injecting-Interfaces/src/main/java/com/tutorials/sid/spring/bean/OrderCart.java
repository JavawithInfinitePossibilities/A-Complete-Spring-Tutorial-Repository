/**
 * 
 */
package com.tutorials.sid.spring.bean;

import org.springframework.stereotype.Component;

import com.tutorials.sid.spring.bean.intf.IOrderDAO;

/**
 * @author Lenovo
 *
 */
@Component
public class OrderCart implements IOrderDAO {

	@Override
	public void orderDao() {
		System.out.println("This is Order cart");
	}

}
