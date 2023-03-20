package com.example.engineerProject.User;

import com.example.engineerProject.User.Dto.AppUserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController("/resource-user")
public class UserResource {
    private final AppUserService userService;

    public UserResource(AppUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-new-agent")
    ResponseEntity<AppUserDto> saveNewUser(@Valid @RequestBody AppUserDto userDto){
        AppUserDto savedUser = userService.registerNewAgent(userDto);
        URI savedUserUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(savedUserUri).body(savedUser);
    }

    @GetMapping("/agent-list")
    ResponseEntity<Set<AppUserDto>> getAgentList(){
        return ResponseEntity.ok(userService.getAllAgents());
    }

    @DeleteMapping("/delete/{email}")
    ResponseEntity<?> deleteAgent(@PathVariable String email) {
        userService.deleteAgentByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update")
    ResponseEntity<AppUserDto> UpdateUserInformation(@Valid @RequestBody AppUserDto appUserDto) {
        return userService.updateUserInformation(appUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }
}
