package com.ds;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] config = { "job/01-job-sheduler-config.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("importProducts");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
//			System.out.println("Exit Status : " + execution.getStatus());
			

		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("Finished Execution of Batch Job");

	}

}