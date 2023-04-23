package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeOutputDto;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;

import java.util.List;

public class CategoryTypeMapper {

    public static CategoryType toTransactionOutPutDto(CategoryType categoryType) {
        return CategoryType.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .description(categoryType.getDescription())
                .name(categoryType.getName())
                .build();
    }

    public static List<CategoryTypeOutputDto> toCategoryTypeList(List<CategoryType> categoryTypeList) {
        return categoryTypeList
            .stream()
            .map(categoryType -> CategoryTypeOutputDto.categoryTypeOutputDtoBuilder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .name(categoryType.getName())
                .updatedAt(categoryType.getUpdatedAt())
                .createdAt(categoryType.getCreatedAt())
                .description(categoryType.getDescription())
                .build())
            .toList();
    }
}
