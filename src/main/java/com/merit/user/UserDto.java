package com.merit.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDto {
    private long userId;
    private String userLogin;
    private String userLastLogin;

    public UserDto(long userId, String userLogin, String userLastLogin) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userLastLogin = userLastLogin;
    }

    public static UserDto userDtoFromEntity(UserEntity user){
        return new UserDto(
                user.getUserId(),
                user.getUserLogin(),
                user.getUserLastLogin()
        );
    }
}
