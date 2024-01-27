/**
 * 
 */
package com.tutorials.sid.spring.bean.collection.properties;

import java.util.Properties;

/**
 * @author Lenovo
 *
 */
public class CountryAndLanguage {
	private Properties countryAndLanguage;

	public Properties getCountryAndLanguage() {
		return countryAndLanguage;
	}

	public void setCountryAndLanguage(Properties countryAndLanguage) {
		this.countryAndLanguage = countryAndLanguage;
	}

	@Override
	public String toString() {
		return "CountryAndLanguage [countryAndLanguage=" + countryAndLanguage + "]";
	}

}
