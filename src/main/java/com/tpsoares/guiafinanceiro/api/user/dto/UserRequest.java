package com.tpsoares.guiafinanceiro.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {
    private final Long userId;
    private final String name;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;
}
