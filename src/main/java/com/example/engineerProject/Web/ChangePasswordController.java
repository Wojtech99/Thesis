package com.example.engineerProject.Web;

import com.example.engineerProject.User.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
    private final AppUserService userService;

    public ChangePasswordController(AppUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam("newPassword") String newPassword) {
        userService.changePassword(newPassword);

        return "redirect:/logout";
    }
}
