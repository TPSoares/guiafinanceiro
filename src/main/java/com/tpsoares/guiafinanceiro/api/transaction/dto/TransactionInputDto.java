package com.tpsoares.guiafinanceiro.api.transaction.dto;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.user.User;
import lombok.Builder;

import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.transaction.Transaction} entity
 */
@Builder
public class TransactionInputDto {
    private final String name;
    private final String transactionValue;
    private final Date transactionDate;
    private final Date createdAt;
    private final Date updatedAt;
    private final User user;
    private final CategoryType categoryType;
    private final SubcategoryType subcategoryType;

    public String getName() {
        return name;
    }

    public String getTransactionValue() {
        return transactionValue;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
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
        TransactionInputDto entity = (TransactionInputDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.transactionValue, entity.transactionValue) &&
                Objects.equals(this.transactionDate, entity.transactionDate) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.categoryType, entity.categoryType) &&
                Objects.equals(this.subcategoryType, entity.subcategoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, transactionValue, transactionDate, createdAt, updatedAt, user, categoryType, subcategoryType);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "transactionValue = " + transactionValue + ", " +
                "transactionDate = " + transactionDate + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")" +
                "user = " + user + ", " +
                "categoryType = " + categoryType + ", " +
                "subcategoryType = " + subcategoryType + ")";
    }
}
