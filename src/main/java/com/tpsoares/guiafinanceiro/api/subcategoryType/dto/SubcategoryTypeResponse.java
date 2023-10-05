package com.tpsoares.guiafinanceiro.api.subcategoryType.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class SubcategoryTypeResponse {
    private final Long subcategoryTypeId;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final String description;
}
