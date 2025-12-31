package com.mglessa.springbatch.job.importusers.step;

import com.mglessa.springbatch.domain.user.User;
import com.mglessa.springbatch.job.importusers.reader.UserReader;
import com.mglessa.springbatch.job.importusers.writer.UserWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImportUsersStepConfig {

    @Bean
    public Step importUsersStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            UserReader reader,
            UserWriter writer
    ) {
        return new StepBuilder("importUsersStep", jobRepository)
                .<User, User>chunk(10, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
