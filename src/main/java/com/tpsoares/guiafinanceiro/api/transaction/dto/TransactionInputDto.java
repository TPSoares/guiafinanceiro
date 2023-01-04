package com.tpsoares.guiafinanceiro.api.transaction.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.transaction.Transaction} entity
 */
public class TransactionInputDto implements Serializable {
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final Long userId;
    private final Long categoryTypeId;
    private final Long subcategoryTypeId;

    public TransactionInputDto(String name, Date createdAt, Date updatedAt, Long userId, Long categoryTypeId, Long subcategoryTypeId) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.categoryTypeId = categoryTypeId;
        this.subcategoryTypeId = subcategoryTypeId;
    }

    public String getName() {
        return name;
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
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.categoryTypeId, entity.categoryTypeId) &&
                Objects.equals(this.subcategoryTypeId, entity.subcategoryTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, updatedAt, userId, categoryTypeId, subcategoryTypeId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")" +
                "userId = " + userId + ", " +
                "categoryTypeId = " + categoryTypeId + ", " +
                "subcategoryTypeId = " + subcategoryTypeId + ")";
    }

    public static TransactionInputDtoBuilder transactionInputDtoBuilder() {
        return new TransactionInputDtoBuilder();
    }

    public static final class TransactionInputDtoBuilder {
        private String name;
        private Date createdAt;
        private Date updatedAt;
        private Long userId;
        private Long categoryTypeId;
        private Long subcategoryTypeId;

        private TransactionInputDtoBuilder() {
        }

        public TransactionInputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TransactionInputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TransactionInputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public TransactionInputDtoBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public TransactionInputDtoBuilder categoryTypeId(Long categoryTypeId) {
            this.categoryTypeId = categoryTypeId;
            return this;
        }

        public TransactionInputDtoBuilder subcategoryTypeId(Long subcategoryTypeId) {
            this.subcategoryTypeId = subcategoryTypeId;
            return this;
        }

        public TransactionInputDto build() {
            return new TransactionInputDto(name, createdAt, updatedAt, userId, categoryTypeId, subcategoryTypeId);
        }
    }
}