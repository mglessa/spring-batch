package com.mglessa.springbatch.job.importusers.writer;

import com.mglessa.springbatch.domain.user.User;
import com.mglessa.springbatch.domain.user.UserRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class UserWriter implements ItemWriter<User> {

    private final UserRepository repository;

    public UserWriter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(Chunk<? extends User> chunk) {
        repository.saveAll(chunk);
    }
}
