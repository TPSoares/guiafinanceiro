package com.tpsoares.guiafinanceiro.api.subcategoryType;

import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeResponse;

import java.util.List;

public class SubcategoryTypeMapper {

    public static SubcategoryType toTransactionOutPutDto(SubcategoryType subcategoryType) {
        return SubcategoryType.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .description(subcategoryType.getDescription())
                .name(subcategoryType.getName())
                .build();
    }

    public static SubcategoryType toEntity(SubcategoryTypeRequest subcategoryTypeRequest) {
        return SubcategoryType.builder()
            .subcategoryTypeId(subcategoryTypeRequest.getSubcategoryTypeId())
            .description(subcategoryTypeRequest.getDescription())
            .name(subcategoryTypeRequest.getName())
            .build();
    }

    public static SubcategoryTypeResponse toDomain(SubcategoryType subcategoryType) {
        return SubcategoryTypeResponse.builder()
            .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
            .description(subcategoryType.getDescription())
            .name(subcategoryType.getName())
            .build();
    }

    public static List<SubcategoryTypeResponse> toSubcategoryTypeList(List<SubcategoryType> subcategoryTypeList) {
        return subcategoryTypeList
            .stream()
            .map(subcategoryType -> SubcategoryTypeResponse.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .name(subcategoryType.getName())
                .createdAt(subcategoryType.getCreatedAt())
                .updatedAt(subcategoryType.getUpdatedAt())
                .description(subcategoryType.getDescription())
                .build())
            .toList();
    }
}
