/**
 * 
 */
package com.tutorials.sid.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class BinarySearchImpl {
	
	@Autowired
	//@Qualifier("quickSortAlgorithm")
	private ISortAlgorithm algorithm;

	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = algorithm.sort(numbers);
		System.out.println(algorithm);
		// Search the array
		return 3;
	}
}
