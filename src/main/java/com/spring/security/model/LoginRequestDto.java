package com.spring.security.model;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String username;
    private String password;
}
