package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeDto;

import java.util.List;

public class CategoryTypeMapper {

    public static CategoryType toTransactionOutPutDto(CategoryType categoryType) {
        return CategoryType.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .description(categoryType.getDescription())
                .name(categoryType.getName())
                .build();
    }

    public static CategoryType toEntity(CategoryTypeDto categoryTypeDto) {
        return CategoryType.builder()
            .categoryTypeId(categoryTypeDto.getCategoryTypeId())
            .description(categoryTypeDto.getDescription())
            .name(categoryTypeDto.getName())
            .build();
    }

    public static CategoryTypeDto toDomain(CategoryType categoryType) {
        return CategoryTypeDto.builder()
            .categoryTypeId(categoryType.getCategoryTypeId())
            .description(categoryType.getDescription())
            .name(categoryType.getName())
            .build();
    }

    public static List<CategoryTypeDto> toCategoryTypeList(List<CategoryType> categoryTypeList) {
        return categoryTypeList
            .stream()
            .map(categoryType -> CategoryTypeDto.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .name(categoryType.getName())
                .updatedAt(categoryType.getUpdatedAt())
                .createdAt(categoryType.getCreatedAt())
                .description(categoryType.getDescription())
                .build())
            .toList();
    }
}
