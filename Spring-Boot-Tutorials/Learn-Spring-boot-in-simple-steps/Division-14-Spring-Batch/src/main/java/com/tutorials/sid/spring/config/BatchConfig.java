/**
 * 
 */
package com.tutorials.sid.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tutorials.sid.spring.itemreader.ItemReaderCustom;
import com.tutorials.sid.spring.listener.MyJobListener;
import com.tutorials.sid.spring.processer.ItemProcesserCustom;
import com.tutorials.sid.spring.writer.ItemWriterCustom;

/**
 * @author Lenovo
 *
 */
@Configuration
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Bean
	public ItemReaderCustom itemReaderCustom() {
		return new ItemReaderCustom();
	}

	@Bean
	public ItemProcesserCustom itemProcesserCustom() {
		return new ItemProcesserCustom();
	}

	@Bean
	public ItemWriterCustom itemwriterCustom() {
		return new ItemWriterCustom();
	}

	@Bean
	public MyJobListener myJobListener() {
		return new MyJobListener();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("Step1").<String, String>chunk(2).reader(itemReaderCustom())
				.processor(itemProcesserCustom()).writer(itemwriterCustom()).build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer()).listener(myJobListener()).start(step())
				.build();

	}

}
