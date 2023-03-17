package com.example.engineerProject.Config;

import com.example.engineerProject.User.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/").permitAll()
                .requestMatchers("/all-approved", "/article/{id}").permitAll()
                .requestMatchers("/announcements", "/announcement/{id}").permitAll()
                .requestMatchers("/images/**", "/styles/**").permitAll()

                .requestMatchers("/agents-list", "/agent-List/delete/{email}",
                        "/agent/register-form", "/agent/save", "/all-unapproved",
                        "/all-unapproved-articles/approve/{id}", "/choose-announcements",
                        "/choose-announcements/save", "/add-agreement", "/add-agreement/save", "/show-agreements",
                        "/show-agreements/delete/{id}",
                        "/show-agreements/download/{id}").hasRole(Role.MANAGER.getDescription())

                .anyRequest().authenticated());


        http.formLogin(login -> login.loginPage("/login")
                .permitAll());

        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**",
                        HttpMethod.GET.name()))
                .logoutSuccessUrl("/")
        );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
