package com.tpsoares.guiafinanceiro.api.transaction.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TransactionDto {
    private final Long transactionId;
    private final String name;
    private final String transactionValue;
    private final Date createdAt;
    private final Date updatedAt;
    private final Date transactionDate;
    private final UserDto user;
    private final CategoryTypeDto categoryType;
    private final SubcategoryTypeDto subcategoryType;
}
