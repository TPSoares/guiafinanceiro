package com.tpsoares.guiafinanceiro.api.subcategoryType;

public class SubcategoryTypeMapper {

    public static SubcategoryType toTransactionOutPutDto(SubcategoryType subcategoryType) {
        return SubcategoryType.builder()
                .subcategoryTypeId(subcategoryType.getSubcategoryTypeId())
                .description(subcategoryType.getDescription())
                .name(subcategoryType.getName())
                .build();
    }
}
