/**
 * 
 */
package com.tutorials.sid.spring.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.tutorials.sid.spring.services.ISortAlgorithm;

/**
 * @author Lenovo
 *
 */
@Component
@Primary
public class BubbleSortAlgorithm implements ISortAlgorithm {

	@Override
	public int[] sort(int[] numbers) {
		return null;
	}

}
