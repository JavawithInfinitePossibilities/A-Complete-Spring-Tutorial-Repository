/**
 * 
 */
package com.tutorials.sid.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.sid.spring.model.db.Coupon;
import com.tutorials.sid.spring.repo.ICouponRepo;

/**
 * @author Lenovo
 * 
 *         Project REST URL:
 *         http://localhost:8080/couponcart/couponapi/createcoupon <br/>
 *         Input value: <br/>
 *         { "code": "SUPERSEAL2021", "discount": 15.000, "exp_date":
 *         "31122021"}
 *         http://localhost:8080/couponcart/couponapi/getcoupon/SUPERSEAL
 *
 */
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	private ICouponRepo iCouponRepo;

	@RequestMapping(value = "/createcoupon", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		Coupon saveCoupon = iCouponRepo.save(coupon);
		return saveCoupon;
	}

	/**
	 * @RequestMapping(value = "/getcoupon/{couponCode}", method =
	 *                       RequestMethod.GET)
	 */
	/**
	 * 
	 * @param couponCode <br/>
	 *                   This is replaced for to check the fault tolerant. <br/>
	 *                   To work properly please replace the above annotation line
	 * @RequestMapping(value = "/getcouponI/{couponCode}", method =
	 *                       RequestMethod.GET)
	 */
	@RequestMapping(value = "/getcoupon/{couponCode}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
		System.out.println("Server-1");
		Coupon getCoupon = iCouponRepo.findByCode(couponCode);
		return getCoupon;
	}
}
