package com.spring.security.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

//	private final PasswordEncoder passwordEncoder ;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(auth -> auth
								.requestMatchers("/login").permitAll()
				.requestMatchers("/public/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
								.requestMatchers("/patient/**").hasRole("PATIENT")
								.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.permitAll());
				return httpSecurity.build();
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails admin = User.withUsername("admin")
//				.password(passwordEncoder.encode("pass"))
//				.roles("ADMIN")
//				.build();
//
//		UserDetails patients = User.withUsername("patient")
//				.password(passwordEncoder.encode("pass"))
//				.roles("PATIENT")
//				.build();
//
//		return new InMemoryUserDetailsManager(admin, patients);
//	}
}
