/**
 * 
 */
package com.tutorials.sid.spring.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutorials.sid.spring.model.dto.Coupon;

/**
 * @author Lenovo
 *
 */
//@FeignClient("zuul-api-getway-services")
@FeignClient("APIGATEWAY-SERVICES")
public interface IFeignCouponClient {

	@GetMapping("/couponcart/couponapi/getcoupon/{couponCode}")
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode);
}
