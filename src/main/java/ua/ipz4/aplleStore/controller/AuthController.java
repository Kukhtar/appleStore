package ua.ipz4.aplleStore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.model.Role;
import ua.ipz4.aplleStore.model.UserModel;
import ua.ipz4.aplleStore.service.AuthService;

@RequestMapping("auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("signup")
    public UserDto signup(@RequestBody UserDto userDto){
        return authService.signUp(userDto, Role.ROLE_USER);
    }

    @PostMapping("signin")
    public UserDto sign(@RequestBody UserDto userDto){
        return authService.signIn(userDto);
    }

    @GetMapping("signout")
    public void signout(){
        authService.signOut();
    }
}
