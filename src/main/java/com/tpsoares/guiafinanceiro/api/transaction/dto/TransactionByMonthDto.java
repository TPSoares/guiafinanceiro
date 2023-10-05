package com.tpsoares.guiafinanceiro.api.transaction.dto;

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

    public String getMonthlyExpense() {
        return monthlyExpense;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getMonthDate() {
        return monthDate;
    }
}
