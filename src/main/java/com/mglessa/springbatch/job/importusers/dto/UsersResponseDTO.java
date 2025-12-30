package com.mglessa.springbatch.job.importusers.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsersResponseDTO {
    private List<UserDTO> users;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
