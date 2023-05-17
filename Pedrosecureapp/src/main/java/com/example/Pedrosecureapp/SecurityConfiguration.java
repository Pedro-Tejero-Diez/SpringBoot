package com.example.Pedrosecureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            .anyRequest().authenticated()
        ).httpBasic();
        
    return http.build();
}

	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
	    }

	}
