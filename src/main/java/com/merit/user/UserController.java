package com.merit.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@RequestMapping(value ="/users")
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
    public UserEntity getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUserById(@PathVariable Long userId) {
        userService.removeUserById(userId);
    }
}
