/**
 * 
 */
package com.tutorials.sid.spring;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
public class Section06RESTfulWebServiceswithSpringandSpringBoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Section06RESTfulWebServiceswithSpringandSpringBoot.class,
				args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		/*SessionLocaleResolver localeResolver = new SessionLocaleResolver();*/
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/*@Bean
	@Primary
	public ResourceBundleMessageSource resourcesBundleMessageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}*/
}
