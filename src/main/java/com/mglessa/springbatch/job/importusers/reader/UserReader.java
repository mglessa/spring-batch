package com.mglessa.springbatch.job.importusers.reader;

import com.mglessa.springbatch.job.importusers.dto.UserDTO;
import com.mglessa.springbatch.job.importusers.dto.UsersResponseDTO;
import com.mglessa.springbatch.domain.user.User;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Iterator;

@Component
public class UserReader implements ItemReader<User> {

    private final RestClient restClient;
    private Iterator<User> iterator;

    public UserReader(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://dummyjson.com")
                .build();
    }

    @Override
    public User read() {
        if (iterator == null) {
            UsersResponseDTO response = restClient.get()
                    .uri("/users")
                    .retrieve()
                    .body(UsersResponseDTO.class);

            if (response == null || response.getUsers() == null) {
                return null;
            }

            iterator = response.getUsers().stream()
                    .map(this::toEntity)
                    .iterator();
        }

        return iterator.hasNext() ? iterator.next() : null;
    }

    private User toEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }
}
