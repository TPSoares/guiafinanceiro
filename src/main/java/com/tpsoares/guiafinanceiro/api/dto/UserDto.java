package com.tpsoares.guiafinanceiro.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private final Long userId;
    private final String name;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;
}
