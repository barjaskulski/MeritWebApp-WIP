package com.merit.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDto {
    private Long userId;
    private String userLogin;
    private LocalDateTime userLastLogin;

    public UserDto(Long userId, String userLogin, LocalDateTime userLastLogin) {
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
