package com.losung360.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/contacts/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }
}
