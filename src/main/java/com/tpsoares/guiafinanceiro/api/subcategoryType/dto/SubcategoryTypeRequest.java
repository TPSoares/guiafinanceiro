package com.tpsoares.guiafinanceiro.api.subcategoryType.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class SubcategoryTypeRequest implements Serializable {
    private final Long subcategoryTypeId;
    private final String description;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
}
