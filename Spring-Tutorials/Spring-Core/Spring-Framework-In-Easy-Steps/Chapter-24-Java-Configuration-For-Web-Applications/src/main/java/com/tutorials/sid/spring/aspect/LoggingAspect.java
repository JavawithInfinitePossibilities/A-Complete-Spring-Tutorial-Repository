/**
 * 
 */
package com.tutorials.sid.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Aspect
@Component
public class LoggingAspect {

	@Before(value = "execution(* com.tutorials.sid.spring.controller..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before calling method : " + joinPoint.getSignature());
	}

	@After(value = "execution(* com.tutorials.sid.spring.controller..*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After calling method : " + joinPoint.getSignature());
	}
}
