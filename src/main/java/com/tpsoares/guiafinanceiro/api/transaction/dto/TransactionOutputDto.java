package com.tpsoares.guiafinanceiro.api.transaction.dto;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.user.User;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.transaction.Transaction} entity
 */
@Builder
public class TransactionOutputDto implements Serializable {
    private final Long transactionId;
    private final String name;

    private final String transactionValue;
    private final Date createdAt;
    private final Date updatedAt;
    private final Date transactionDate;
    private final User user;
    private final CategoryType categoryType;
    private final SubcategoryType subcategoryType;

    public TransactionOutputDto(Long transactionId, String name, String transactionValue, Date createdAt, Date updatedAt, Date transactionDate, User user, CategoryType categoryType, SubcategoryType subcategoryType) {
        this.transactionId = transactionId;
        this.name = name;
        this.transactionValue = transactionValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.transactionDate = transactionDate;
        this.user = user;
        this.categoryType = categoryType;
        this.subcategoryType = subcategoryType;
    }

    public Long getTransactionId() {
        return transactionId;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public User getUser() {
        return user;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public SubcategoryType getSubcategoryType() {
        return subcategoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionOutputDto entity = (TransactionOutputDto) o;
        return Objects.equals(this.transactionId, entity.transactionId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.transactionValue, entity.transactionValue) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.transactionDate, entity.transactionDate) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.categoryType, entity.categoryType) &&
                Objects.equals(this.subcategoryType, entity.subcategoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, name, transactionValue, createdAt, updatedAt, transactionDate, user, categoryType, subcategoryType);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "transactionId = " + transactionId + ", " +
                "name = " + name + ", " +
                "transactionValue = " + transactionValue + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")" +
                "transactionDate = " + transactionDate + ")" +
                "user = " + user + ", " +
                "categoryType = " + categoryType + ", " +
                "subcategoryType = " + subcategoryType + ")";
    }
}
