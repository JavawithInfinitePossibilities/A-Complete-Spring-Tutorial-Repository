/**
 * 
 */
package com.tutorials.sid.spring.processer;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author Lenovo
 *
 */
public class ItemProcesserCustom implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Item we are processing : " + item);
		return "Processed " + item.toUpperCase();
	}

}
