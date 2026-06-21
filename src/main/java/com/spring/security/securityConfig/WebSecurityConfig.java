package com.spring.security.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

//	private final PasswordEncoder passwordEncoder ;

	private final JwtAuthFilter jwtAuthFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				.csrf(csrfConfig->csrfConfig.disable())
				.sessionManagement(sessionConfig->
						sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
								.requestMatchers("/login").permitAll()
				.requestMatchers("/public/**", "/auth/**").permitAll()
//				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//				.formLogin(form -> form
//						.permitAll());
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
