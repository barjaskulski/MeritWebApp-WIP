package com.merit.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class UserService {

    private final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<UserDto> getAllUsers() {
        return userRepositories.findAll().stream().map(UserDto::userDtoFromEntity).collect(Collectors.toList());
    }

    public UserEntity getUserById(long id){
        return userRepositories.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userRepositories.save(userEntity);
    }

    public void removeUserById(long id) {
        UserEntity userEntityToDelete = userRepositories.findById(id).orElseThrow(NoSuchElementException::new);
        userRepositories.delete(userEntityToDelete);
    }


}
