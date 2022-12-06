package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserCredentialsDto;

public class AppUserCredentialsMapper {
    static AppUserCredentialsDto map(AppUser user){
        return new AppUserCredentialsDto(
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }
}
