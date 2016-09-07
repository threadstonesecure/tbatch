package com.ds.listeners;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ProductsJobListener implements JobExecutionListener {
	public void beforeJob(JobExecution jobExecution) {
		// Called when job starts
		System.out.println("Before job execution");
		System.out.println("JobId : "+jobExecution.getJobId());
	}

	public void afterJob(JobExecution jobExecution) {
		System.out.println("After job execution");
		System.out.println("JobId : "+jobExecution.getJobId());
		System.out.println("Execution status : "+jobExecution.getStatus());
		
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			// Called when job ends successfully
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			// Called when job ends in failure
		}
	}
}