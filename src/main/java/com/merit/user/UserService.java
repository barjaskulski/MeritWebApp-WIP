package com.merit.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserService {

    private final UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<UserEntity> getAllUsers() {
        return userRepositories.findAll();
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
