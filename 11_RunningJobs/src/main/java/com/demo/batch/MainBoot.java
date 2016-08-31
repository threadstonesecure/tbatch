package com.demo.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.batch.sample.ApplicationConfiguration;
import com.demo.batch.util.MainHelper;

@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ApplicationConfiguration.class)})
@EnableAutoConfiguration
public class MainBoot {

    public static void main(String... args) {

        ApplicationContext context = SpringApplication.run(MainBoot.class);

        MainHelper.reportPeople(context.getBean(JdbcTemplate.class));

    }
}
