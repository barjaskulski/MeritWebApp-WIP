package com.merit.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserEntity getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUserById(@PathVariable long userId) {
        userService.removeUserById(userId);
    }
}
