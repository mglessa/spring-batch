package com.mglessa.springbatch.job.importusers;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportUsersJobConfig {

    @Bean
    public Job importUsersJob(JobRepository jobRepository, Step importUsersStep, Step truncateUsersStep) {
        return new JobBuilder("importUsersJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(truncateUsersStep)
                .next(importUsersStep)
                .build();
    }
}
