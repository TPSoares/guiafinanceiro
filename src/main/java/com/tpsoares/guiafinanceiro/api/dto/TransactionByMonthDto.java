package com.tpsoares.guiafinanceiro.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TransactionByMonthDto {

    private String monthlyExpense;
    private String monthlyIncome;
    private String monthDate;
}
