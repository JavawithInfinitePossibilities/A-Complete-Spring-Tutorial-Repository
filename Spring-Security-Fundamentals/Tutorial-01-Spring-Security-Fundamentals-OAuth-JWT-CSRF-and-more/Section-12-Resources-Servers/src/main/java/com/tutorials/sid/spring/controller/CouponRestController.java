/**
 *
 */
package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.model.Coupon;
import com.tutorials.sid.spring.repositories.CouponRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kunmu <br/>
 *         URL:
 *         http://localhost:8090/Section-07-CSRF/couponapi/getcoupon/NEWYEAR
 *         http://localhost:8090/Section-07-CSRF/couponapi/couponsave
 *         {
 *     			"id": 1,
 *     			"code": "NEWYEAR",
 *     			"discount": 20.00,
 *     			"expDate": "22062024"
 *            }
 *
 */
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    private CouponRepositories couponRepositories;

    @RequestMapping(value = "/couponsave", method = RequestMethod.POST, consumes = "application/json")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponRepositories.save(coupon);
    }

    @RequestMapping(value = "/getcoupon/{couponCode}", method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
        return couponRepositories.getByCode(couponCode);
    }
}
