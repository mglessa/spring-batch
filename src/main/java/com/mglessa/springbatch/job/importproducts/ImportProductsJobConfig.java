package com.mglessa.springbatch.job.importproducts;

import com.mglessa.springbatch.domain.product.Product;
import com.mglessa.springbatch.job.importproducts.reader.ProductReader;
import com.mglessa.springbatch.job.importproducts.writer.ProductWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportProductsJobConfig {

    @Bean
    public Job importProductsJob(JobRepository jobRepository, Step importProductsStep, Step truncateProductsStep) {
        return new JobBuilder("importProductsJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(truncateProductsStep)
                .next(importProductsStep)
                .build();
    }

}
