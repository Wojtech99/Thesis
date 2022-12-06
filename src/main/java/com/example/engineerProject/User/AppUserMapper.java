package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserDto;

public class AppUserMapper {
    static AppUserDto map(AppUser appUser) {
        return new AppUserDto(
                appUser.getId(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getPhoneNumber(),
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.getAnnouncements(),
                appUser.getArticles(),
                appUser.getRole()
        );
    }

    static AppUser map(AppUserDto appUserDto) {
        AppUser appUser = new AppUser(
                appUserDto.getId(),
                appUserDto.getFirstName(),
                appUserDto.getLastName(),
                appUserDto.getPhoneNumber(),
                appUserDto.getEmail(),
                appUserDto.getPassword(),
                appUserDto.getRole()
        );

        appUser.setAnnouncements(appUserDto.getAnnouncements());
        appUser.setArticles(appUserDto.getArticles());

        return appUser;
    }
}
