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
@Component("orderDaoImpl")
public class OrderDaoImpl implements IOrderDAO {

	@Override
	public void orderDao() {
		System.out.println("This is Order impl DAO.");
	}

}
