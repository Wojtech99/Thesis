package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserCredentialsDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;

    public CustomUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User with email \"%s\" not found", username)));
    }

    private UserDetails createUserDetails(AppUserCredentialsDto appUserCredentialsDto){
        return User.builder()
                .username(appUserCredentialsDto.getEmail())
                .password(appUserCredentialsDto.getPassword())
                .roles(appUserCredentialsDto.getRole().getDescription())
                .build();
    }
}
