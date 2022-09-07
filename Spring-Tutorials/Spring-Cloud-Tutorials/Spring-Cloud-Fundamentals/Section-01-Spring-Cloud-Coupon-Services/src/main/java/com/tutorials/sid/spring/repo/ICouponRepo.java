/**
 * 
 */
package com.tutorials.sid.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorials.sid.spring.model.db.Coupon;

/**
 * @author Lenovo
 *
 */
public interface ICouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String couponCode);

}
