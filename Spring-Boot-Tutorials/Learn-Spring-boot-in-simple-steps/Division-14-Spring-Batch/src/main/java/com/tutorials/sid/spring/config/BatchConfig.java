/**
 *
 */
package com.tutorials.sid.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.transaction.PlatformTransactionManager;
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

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public Step step() {
        return new StepBuilder("Step1", jobRepository)
                .<String, String>chunk(2, platformTransactionManager)
                .reader(itemReaderCustom())
                .processor(itemProcesserCustom())
                .writer(itemwriterCustom())
                .build();
    }

    @Bean
    public Job job() {
        return new JobBuilder("job1", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(myJobListener()).start(step())
                .build();

    }

}

