package com.tpsoares.guiafinanceiro.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private final TransactionTypeDto transactionType;
    private final SubcategoryTypeDto subcategoryType;
}
