package com.tpsoares.guiafinanceiro.api.user;
public class UserMapper {

    public static User toTransactionOutPutDto(User user) {
        return User.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
