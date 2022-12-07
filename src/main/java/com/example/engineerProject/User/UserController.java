package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserDto;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class UserController {
    private final AppUserService userService;

    public UserController(AppUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/agents-list")
    String allAgentsList(Model model) {
       Set<AppUserDto> userDtoSet = userService.getAllAgents();
       model.addAttribute("userList", userDtoSet);

       return "all-agent-list";
    }

    @RequestMapping(
            value = "/agent-List/delete",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAgent(@ModelAttribute("agentEmail") String email) {
        userService.deleteAgentByEmail(email);

        return "redirect:/agents-list";
    }


    @GetMapping("/agent/register-form")
    String registerNewUser(Model model) {
        model.addAttribute("user", new AppUserDto());

        return "new-agent-form";
    }

    @PostMapping("/agent/save")
    String saveNewAgent(@Valid @ModelAttribute("user") AppUserDto appUserDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "new-agent-form";
        }

        userService.registerNewAgent(appUserDto);

        return "redirect:/agent/register-form";
    }


    @GetMapping("/user/update-form")
    String updateAgentForm(Model model) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUserDto appUserDto = userService.getUserByEmail(currentUserEmail);

        model.addAttribute("user", appUserDto);

        return "edit-user-form";
    }

    @RequestMapping(
            value = "/user/update-form/save",
            method = {RequestMethod.PATCH, RequestMethod.GET}
    )
    String updateAgentInformation(@Valid @ModelAttribute("user") AppUserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user-form";
        }
        userService.updateUserInformation(userDto);

        return "redirect:/agents-list";
    }
}
