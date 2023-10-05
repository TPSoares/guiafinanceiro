package com.tpsoares.guiafinanceiro.api.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TransactionMonthlyBySubCategoryTypeDto {
    private String monthlyExpense;
    private String subcategoryType;
}
