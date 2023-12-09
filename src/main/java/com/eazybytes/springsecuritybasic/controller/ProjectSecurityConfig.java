package com.eazybytes.springsecuritybasic.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // H2 configuratio
                .headers(headers -> headers.frameOptions().sameOrigin()) // H2 Configuratio
                .authorizeRequests()
                .requestMatchers("/mybalance", "/myloans", "/myaccount",
                        "/mycards")
                .authenticated()
                .requestMatchers("/contract", "/notices", "/h2-console/**").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();

    }

}
