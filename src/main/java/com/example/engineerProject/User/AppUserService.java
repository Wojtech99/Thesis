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

    public Set<AppUserDto> getAllUsers() {
        return appUserRepository.getAll().stream()
                .map(AppUserMapper::map)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        if (isCurrentUserAdmin()) {
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

    private boolean isCurrentUserAdmin() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals(Role.MANAGER.getDescription()));
    }
}
