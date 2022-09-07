/**
 * 
 */
package com.tutorials.sid.spring.Services;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class MyMath {

	public int sum(int... values) {
		int sum = IntStream.range(0, values.length).map(i -> values[i]).sum();
		return sum;
	}

}
