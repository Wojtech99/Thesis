package com.example.engineerProject.Web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/change-password")
public class ChangePasswordResource {

    private final PasswordEncoder passwordEncoder;

    public ChangePasswordResource(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/change")
    ResponseEntity<?> changePassword(@RequestParam String password) {
        String newPasswordHash = passwordEncoder.encode(password);
        return ResponseEntity.noContent().build();
    }
}
