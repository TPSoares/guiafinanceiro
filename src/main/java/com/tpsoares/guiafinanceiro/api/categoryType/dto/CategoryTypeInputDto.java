package com.tpsoares.guiafinanceiro.api.categoryType.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.categoryType.CategoryType} entity
 */
public class CategoryTypeInputDto implements Serializable {
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;

    public CategoryTypeInputDto(String name, Date createdAt, Date updatedAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryTypeInputDto entity = (CategoryTypeInputDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }

    public static CategoryTypeInputDtoBuilder categoryTypeInputDtoBuilder() {
        return new CategoryTypeInputDtoBuilder();
    }

    public static final class CategoryTypeInputDtoBuilder {
        private String name;
        private Date createdAt;
        private Date updatedAt;

        private CategoryTypeInputDtoBuilder() {
        }

        public CategoryTypeInputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryTypeInputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryTypeInputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryTypeInputDto build() {
            return new CategoryTypeInputDto(name, createdAt, updatedAt);
        }
    }
}