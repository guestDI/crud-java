package com.demo.example.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails chris = User.builder()
                .username("chris")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails robert = User.builder()
                .username("robert")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails scarlett = User.builder()
                .username("scarlett")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "Admin")
                .build();

        return new InMemoryUserDetailsManager(chris, robert, scarlett);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/authors").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/authors/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/api/authors").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/author/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
