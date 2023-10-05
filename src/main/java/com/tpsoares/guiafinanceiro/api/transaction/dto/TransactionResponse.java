package com.tpsoares.guiafinanceiro.api.transaction.dto;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeResponse;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeResponse;
import com.tpsoares.guiafinanceiro.api.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class TransactionResponse {
    private final Long transactionId;
    private final String name;
    private final String transactionValue;
    private final Date createdAt;
    private final Date updatedAt;
    private final Date transactionDate;
    private final UserResponse user;
    private final CategoryTypeResponse categoryType;
    private final SubcategoryTypeResponse subcategoryType;
}
