package com.mglessa.springbatch.job.importproducts.step;

import com.mglessa.springbatch.job.importproducts.tasklet.TruncateProductsTasklet;
import com.mglessa.springbatch.job.importusers.tasklet.TruncateUsersTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TruncateProductsStepConfig {

    @Bean
    public Step truncateProductsStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            TruncateProductsTasklet tasklet
    ) {
        return new StepBuilder("truncateProductsStep", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }
}
