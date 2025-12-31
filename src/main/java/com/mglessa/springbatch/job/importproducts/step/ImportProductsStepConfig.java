package com.mglessa.springbatch.job.importproducts.step;

import com.mglessa.springbatch.domain.product.Product;
import com.mglessa.springbatch.job.importproducts.reader.ProductReader;
import com.mglessa.springbatch.job.importproducts.writer.ProductWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImportProductsStepConfig {

    @Bean
    public Step importProductsStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ProductReader reader,
            ProductWriter writer
    ) {
        return new StepBuilder("importProductsStep", jobRepository)
                .<Product, Product>chunk(10, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
