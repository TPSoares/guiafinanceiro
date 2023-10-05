package com.tpsoares.guiafinanceiro.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {
    private final Long userId;
    private final String name;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;
}
