package com.mglessa.springbatch.job.importusers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
}
