package com.tpsoares.guiafinanceiro.api.categoryType.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategoryTypeDto {
    private final Long categoryTypeId;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final String description;
}
