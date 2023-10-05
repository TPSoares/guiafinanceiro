package com.tpsoares.guiafinanceiro.api.transaction.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.transaction.Transaction} entity
 */
@Getter
@Builder
public class TransactionRequest {
    private final String name;
    private final String transactionValue;
    private final Date transactionDate;
    private final Date createdAt;
    private final Date updatedAt;
    private final Long userId;
    private final Long categoryTypeId;
    private final Long subcategoryTypeId;
}
