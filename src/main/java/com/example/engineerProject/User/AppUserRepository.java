package com.example.engineerProject.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByEmail(String email);

    Set<AppUser> getAppUsersByRole(Role role);

    void deleteAppUserByEmail(String email);
}
