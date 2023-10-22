package com.tpsoares.guiafinanceiro.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TransactionMonthlyByCategoryTypeDto {
    private String monthlyExpense;
    private String categoryType;
}
