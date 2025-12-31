package com.mglessa.springbatch.job.importusers.step;

import com.mglessa.springbatch.job.importusers.tasklet.TruncateUsersTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TruncateUsersStepConfig {

    @Bean
    public Step truncateUsersStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            TruncateUsersTasklet tasklet
    ) {
        return new StepBuilder("truncateUsersStep", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }
}
