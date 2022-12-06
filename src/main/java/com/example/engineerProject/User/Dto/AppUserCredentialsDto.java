package com.example.engineerProject.User.Dto;

import com.example.engineerProject.User.Role;

public class AppUserCredentialsDto {
    private final String email;
    private final String password;
    private final Role role;

    public AppUserCredentialsDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
