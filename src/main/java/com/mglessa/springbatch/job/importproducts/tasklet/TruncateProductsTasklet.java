package com.mglessa.springbatch.job.importproducts.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TruncateProductsTasklet implements Tasklet {

    private final JdbcTemplate jdbcTemplate;

    public TruncateProductsTasklet(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) {

        jdbcTemplate.execute("TRUNCATE TABLE dummy.products RESTART IDENTITY CASCADE");
        return RepeatStatus.FINISHED;
    }
}
