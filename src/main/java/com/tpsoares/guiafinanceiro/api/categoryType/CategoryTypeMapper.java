package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeResponse;

import java.util.List;

public class CategoryTypeMapper {

    public static CategoryType toTransactionOutPutDto(CategoryType categoryType) {
        return CategoryType.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .description(categoryType.getDescription())
                .name(categoryType.getName())
                .build();
    }

    public static CategoryType toEntity(CategoryTypeRequest categoryTypeRequest) {
        return CategoryType.builder()
            .categoryTypeId(categoryTypeRequest.getCategoryTypeId())
            .description(categoryTypeRequest.getDescription())
            .name(categoryTypeRequest.getName())
            .build();
    }

    public static CategoryTypeResponse toDomain(CategoryType categoryType) {
        return CategoryTypeResponse.builder()
            .categoryTypeId(categoryType.getCategoryTypeId())
            .description(categoryType.getDescription())
            .name(categoryType.getName())
            .build();
    }

    public static List<CategoryTypeResponse> toCategoryTypeList(List<CategoryType> categoryTypeList) {
        return categoryTypeList
            .stream()
            .map(categoryType -> CategoryTypeResponse.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .name(categoryType.getName())
                .updatedAt(categoryType.getUpdatedAt())
                .createdAt(categoryType.getCreatedAt())
                .description(categoryType.getDescription())
                .build())
            .toList();
    }
}
