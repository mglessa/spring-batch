package com.mglessa.springbatch.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "dummy")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;

}
