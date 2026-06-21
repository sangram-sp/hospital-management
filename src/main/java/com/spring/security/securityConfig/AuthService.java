package com.spring.security.securityConfig;

import com.spring.security.model.LoginRequestDto;
import com.spring.security.model.LoginResponseDto;
import com.spring.security.model.SignupRequestDto;
import com.spring.security.model.User;
import com.spring.security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;

    private final AuthUtil authUtil;

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;


    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(token, user.getId());
    }

    public SignupRequestDto signup(LoginRequestDto signupRequestDto){
        User user = userRepo.findByUsername(signupRequestDto.getUsername()).orElse(null);
        if(user !=null) throw new IllegalArgumentException("User Already exists");
        user = userRepo.save(User.builder().username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );
        return new SignupRequestDto(user.getId(), user.getUsername());
    }

}

//1.31
