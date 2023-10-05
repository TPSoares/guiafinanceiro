package com.tpsoares.guiafinanceiro.api.categoryType.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class CategoryTypeResponse {
    private final Long categoryTypeId;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final String description;
}
