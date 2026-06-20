package com.spring.security.model;

import lombok.Data;

@Data
public class LoginResponseDto {

    String jwt;
    Long userId;
}
