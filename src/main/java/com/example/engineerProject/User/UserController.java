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

    /**
     * show all agents
     * @param model model
     * @return String
     */
    @GetMapping("/agents-list")
    String allAgentsList(Model model) {
       Set<AppUserDto> userDtoSet = userService.getAllAgents();
       model.addAttribute("agentList", userDtoSet);

       return "all-agent-list";
    }

    /**
     * delete agent by email
     * @param email String
     * @return String
     */
    @RequestMapping(
            value = "/agent-List/delete/{email}",
            method = {RequestMethod.DELETE, RequestMethod.GET}
    )
    String deleteAgent(@PathVariable("email") String email) {
        userService.deleteAgentByEmail(email);

        return "redirect:/agents-list";
    }


    /**
     * show new agent form
     * @param model Model
     * @return String
     */
    @GetMapping("/agent/register-form")
    String registerNewUser(Model model) {
        model.addAttribute("agent", new AppUserDto());

        return "new-agent-form";
    }

    /**
     * save new agent
     * @param appUserDto AppUserDto
     * @param bindingResult BindingResult
     * @return String
     */
    @RequestMapping(
            value = "/agent/save",
            method = {RequestMethod.POST, RequestMethod.POST}
    )
    String saveNewAgent(@Valid @ModelAttribute("agent") AppUserDto appUserDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "new-agent-form";
        }

        userService.registerNewAgent(appUserDto);

        return "redirect:/agent/register-form";
    }

    /**
     * show edit user information form
     * @param model Model
     * @return String
     */
    @GetMapping("/user/update-form")
    String updateAgentForm(Model model) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        AppUserDto appUserDto = userService.getUserByEmail(currentUserEmail);

        model.addAttribute("userToEdit", appUserDto);

        return "edit-user-form";
    }

    /**
     * update current user information
     * @param userDto AppUserDto
     * @param bindingResult BindingResult
     * @return String
     */
    @RequestMapping(
            value = "/user/update-form/update",
            method = {RequestMethod.PATCH, RequestMethod.POST}
    )
    String updateUserInformation(@Valid @ModelAttribute("userToEdit") AppUserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user-form";
        }

        userService.updateUserInformation(userDto);

        return "redirect:/user-information";
    }

    /**
     * show user information
     * @param model Model
     * @return String
     */
    @GetMapping("/user-information")
    String takeUserInformation(Model model) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUserDto userDto = userService.getUserByEmail(currentUserEmail);

        model.addAttribute("user", userDto);

        return "user-information";
    }
}
