package com.tutorials.sid.spring;

import org.springframework.batch.core.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Division14SpringBatch.class)
class Division14SpringBatchTest {

	@Autowired
	private JobLauncher jobLuncher;

	@Autowired
	private Job job;

	@Test
	void testBatch() throws JobExecutionAlreadyRunningException, JobInstanceAlreadyCompleteException,
			JobParametersInvalidException, JobRestartException {
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		jobLuncher.run(job, jobParameters);
	}

}
