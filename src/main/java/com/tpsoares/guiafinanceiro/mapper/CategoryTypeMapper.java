package com.tpsoares.guiafinanceiro.mapper;

import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import com.tpsoares.guiafinanceiro.model.CategoryType;

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
                .createdAt(categoryType.getCreatedAt())
                .updatedAt(categoryType.getUpdatedAt())
                .description(categoryType.getDescription())
                .build())
            .toList();
    }
}
