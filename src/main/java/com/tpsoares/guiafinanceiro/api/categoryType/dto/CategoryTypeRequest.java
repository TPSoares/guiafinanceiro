package com.tpsoares.guiafinanceiro.api.categoryType.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class CategoryTypeRequest implements Serializable {
    private final Long categoryTypeId;
    private final String description;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
}
