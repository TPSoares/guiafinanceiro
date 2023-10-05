package com.tpsoares.guiafinanceiro.api.subcategoryType;

import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeDto;

import java.util.List;

public class SubcategoryTypeMapper {

    public static SubcategoryType toTransactionOutPutDto(SubcategoryType subcategoryType) {
        return SubcategoryType.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .description(subcategoryType.getDescription())
                .name(subcategoryType.getName())
                .build();
    }

    public static SubcategoryType toEntity(SubcategoryTypeDto subcategoryTypeDto) {
        return SubcategoryType.builder()
            .subcategoryTypeId(subcategoryTypeDto.getSubcategoryTypeId())
            .description(subcategoryTypeDto.getDescription())
            .name(subcategoryTypeDto.getName())
            .build();
    }

    public static SubcategoryTypeDto toDomain(SubcategoryType subcategoryType) {
        return SubcategoryTypeDto.builder()
            .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
            .description(subcategoryType.getDescription())
            .name(subcategoryType.getName())
            .build();
    }

    public static List<SubcategoryTypeDto> toSubcategoryTypeList(List<SubcategoryType> subcategoryTypeList) {
        return subcategoryTypeList
            .stream()
            .map(subcategoryType -> SubcategoryTypeDto.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .name(subcategoryType.getName())
                .createdAt(subcategoryType.getCreatedAt())
                .updatedAt(subcategoryType.getUpdatedAt())
                .description(subcategoryType.getDescription())
                .build())
            .toList();
    }
}
