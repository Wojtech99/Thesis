package com.example.engineerProject.Web;

import com.example.engineerProject.User.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class ChangePasswordController {
    private final AppUserService userService;

    public ChangePasswordController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/change-password")
    String changePasswordForm() {
        return "change-password";
    }

    @PostMapping("/change-password/save")
    String changePassword(@RequestParam("newPassword") String newPassword) {
        userService.changePassword(newPassword);

        return "redirect:/logout";
    }
}
