/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kunmu
 *
 */
public interface CouponRepositories extends JpaRepository<Coupon, Long> {

	Coupon getByCode(String couponCode);

	Coupon findByCode(String code);

}
