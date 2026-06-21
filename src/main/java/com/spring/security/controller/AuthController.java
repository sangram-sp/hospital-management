package com.spring.security.controller;

import com.spring.security.model.LoginRequestDto;
import com.spring.security.model.LoginResponseDto;
import com.spring.security.model.SignupRequestDto;
import com.spring.security.securityConfig.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRequestDto> signup(@RequestBody LoginRequestDto signup){

        return ResponseEntity.ok(authService.signup(signup));
    }
}
