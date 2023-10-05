package com.tpsoares.guiafinanceiro.api.user;

import com.tpsoares.guiafinanceiro.api.user.dto.UserRequest;
import com.tpsoares.guiafinanceiro.api.user.dto.UserResponse;

public class UserMapper {

    public static User toEntity(UserRequest userRequest) {
        return User.builder()
            .userId(userRequest.getUserId())
            .email(userRequest.getEmail())
            .name(userRequest.getName())
            .build();
    }

    public static UserResponse toDomain(User user) {
        return UserResponse.builder()
            .userId(user.getUserId())
            .email(user.getEmail())
            .name(user.getName())
            .build();
    }
}
