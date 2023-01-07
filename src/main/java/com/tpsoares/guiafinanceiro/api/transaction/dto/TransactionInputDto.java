package com.tpsoares.guiafinanceiro.api.transaction.dto;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.transaction.Transaction} entity
 */
@Builder
public class TransactionInputDto implements Serializable {
    private final String name;
    private final String transactionValue;
    private final Date createdAt;
    private final Date updatedAt;
    private final Long userId;
    private final Long categoryTypeId;
    private final Long subcategoryTypeId;

    public TransactionInputDto(String name, String transactionValue, Date createdAt, Date updatedAt, Long userId, Long categoryTypeId, Long subcategoryTypeId) {
        this.name = name;
        this.transactionValue = transactionValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.categoryTypeId = categoryTypeId;
        this.subcategoryTypeId = subcategoryTypeId;
    }

    public String getName() {
        return name;
    }

    public String getTransactionValue() {
        return transactionValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCategoryTypeId() {
        return categoryTypeId;
    }

    public Long getSubcategoryTypeId() {
        return subcategoryTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionInputDto entity = (TransactionInputDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.transactionValue, entity.transactionValue) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.categoryTypeId, entity.categoryTypeId) &&
                Objects.equals(this.subcategoryTypeId, entity.subcategoryTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, transactionValue, createdAt, updatedAt, userId, categoryTypeId, subcategoryTypeId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "transactionValue = " + transactionValue + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")" +
                "userId = " + userId + ", " +
                "categoryTypeId = " + categoryTypeId + ", " +
                "subcategoryTypeId = " + subcategoryTypeId + ")";
    }
}
