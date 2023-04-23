package com.tpsoares.guiafinanceiro.api.subcategoryType;

import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeOutputDto;

import java.util.List;

public class SubcategoryTypeMapper {

    public static SubcategoryType toTransactionOutPutDto(SubcategoryType subcategoryType) {
        return SubcategoryType.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .description(subcategoryType.getDescription())
                .name(subcategoryType.getName())
                .build();
    }

    public static List<SubcategoryTypeOutputDto> toSubcategoryTypeList(List<SubcategoryType> subcategoryTypeList) {
        return subcategoryTypeList
            .stream()
            .map(subcategoryType -> SubcategoryTypeOutputDto.subcategoryTypeOutputDtoBuilder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .name(subcategoryType.getName())
                .createdAt(subcategoryType.getCreatedAt())
                .updatedAt(subcategoryType.getUpdatedAt())
                .description(subcategoryType.getDescription())
                .build())
            .toList();
    }
}
