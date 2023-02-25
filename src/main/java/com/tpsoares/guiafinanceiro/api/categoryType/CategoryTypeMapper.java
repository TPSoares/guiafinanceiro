package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;

public class CategoryTypeMapper {

    public static CategoryType toTransactionOutPutDto(CategoryType categoryType) {
        return CategoryType.builder()
                .categoryTypeId(categoryType.getCategoryTypeId())
                .description(categoryType.getDescription())
                .name(categoryType.getName())
                .build();
    }
}
