package com.tpsoares.guiafinanceiro.api.user;

import com.tpsoares.guiafinanceiro.api.user.dto.UserRequest;
import com.tpsoares.guiafinanceiro.api.user.dto.UserDto;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        return User.builder()
            .userId(userDto.getUserId())
            .email(userDto.getEmail())
            .name(userDto.getName())
            .build();
    }

    public static UserDto toDomain(User user) {
        return UserDto.builder()
            .userId(user.getUserId())
            .email(user.getEmail())
            .name(user.getName())
            .build();
    }
}
