package ua.ipz4.aplleStore.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.mapper.UserMapper;
import ua.ipz4.aplleStore.repository.UserRepo;


@RequestMapping("users")
@AllArgsConstructor
@RestController
public class UserController {

    private UserRepo userRepo;
    private UserMapper userMapper;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userMapper.entityToDto(userRepo.save(userMapper.dtoToEntity(userDto)));
    }

    @GetMapping("byName")
    public UserDto getUserByName(String name) {
        return userMapper.entityToDto(userRepo.findByLogin(name));
    }
}
