package com.tpsoares.guiafinanceiro.mapper;

import com.tpsoares.guiafinanceiro.api.dto.UserDto;
import com.tpsoares.guiafinanceiro.model.User;

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
