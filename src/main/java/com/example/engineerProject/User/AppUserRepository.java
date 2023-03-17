package com.example.engineerProject.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByEmail(String email);

    AppUser getAppUserByEmail(String email);

    Set<AppUser> getAppUsersByRole(Role role);

    void deleteAppUserByEmail(String email);
}
