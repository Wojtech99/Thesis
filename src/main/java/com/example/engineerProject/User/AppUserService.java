package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserCredentialsDto;
import com.example.engineerProject.User.Dto.AppUserDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<AppUserCredentialsDto> findCredentialsByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email)
                .map(AppUserCredentialsMapper::map);
    }

    public Set<AppUserDto> getAllAgents() {
        return appUserRepository.getAppUsersByRole(Role.AGENT).stream()
                .map(AppUserMapper::map)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        if (isCurrentUserManager()) {
            appUserRepository.deleteAppUserByEmail(email);
        }
    }

    @Transactional
    public AppUserDto registerNewUser(AppUserDto appUserDto) {
        AppUser userToSave = new AppUser();

        userToSave.setFirstName(appUserDto.getFirstName());
        userToSave.setLastName(appUserDto.getLastName());
        userToSave.setEmail(appUserDto.getEmail());
        userToSave.setRole(Role.AGENT);

        String passwordHash = passwordEncoder.encode(appUserDto.getPassword());
        userToSave.setPassword(passwordHash);

        AppUser savedUser = appUserRepository.save(userToSave);
        return AppUserMapper.map(savedUser);
    }

    private boolean isCurrentUserManager() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals(Role.MANAGER.getDescription()));
    }

    @Transactional
    public Optional<AppUserDto> updateUserInformation(AppUserDto appUserDto) {
        if (appUserRepository.findById(appUserDto.getId()).isEmpty()){
            return Optional.empty();
        }

        AppUser currentAppUser = appUserRepository.findById(appUserDto.getId()).get();
        AppUser userToSave = setEntityFields(currentAppUser, appUserDto);
        AppUser savedUser = appUserRepository.save(userToSave);

        return Optional.of(AppUserMapper.map(savedUser));
    }

    private AppUser setEntityFields(AppUser user, AppUserDto userDto) {
        if (!userDto.getFirstName().isEmpty()) {
            user.setFirstName(userDto.getFirstName());
        }
        if (!userDto.getLastName().isEmpty()) {
            user.setLastName(userDto.getLastName());
        }
        if (userDto.getPhoneNumber() != null) {
            user.setPhoneNumber(user.getPhoneNumber());
        }

        return user;
    }
}
