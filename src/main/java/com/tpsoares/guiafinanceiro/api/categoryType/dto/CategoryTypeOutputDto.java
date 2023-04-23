package com.tpsoares.guiafinanceiro.api.categoryType.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.categoryType.CategoryType} entity
 */
public class CategoryTypeOutputDto implements Serializable {
    private final Long categoryTypeId;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final String description;

    public CategoryTypeOutputDto(Long categoryTypeId, String name, Date createdAt, Date updatedAt, String description) {
        this.categoryTypeId = categoryTypeId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
    }

    public Long getCategoryTypeId() {
        return categoryTypeId;
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

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryTypeOutputDto entity = (CategoryTypeOutputDto) o;
        return Objects.equals(this.categoryTypeId, entity.categoryTypeId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryTypeId, name, createdAt, description, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryTypeId = " + categoryTypeId + ", " +
                "name = " + name + ", " +
                "createdAt = " + createdAt + ", " +
                "description = " + description + ", " +
                "updatedAt = " + updatedAt + ")";
    }

    public static CategoryTypeOutputDtoBuilder categoryTypeOutputDtoBuilder() {
        return new CategoryTypeOutputDtoBuilder();
    }

    public static final class CategoryTypeOutputDtoBuilder {
        private Long categoryTypeId;
        private String name;
        private Date createdAt;
        private Date updatedAt;
        private String description;

        private CategoryTypeOutputDtoBuilder() {
        }

        public CategoryTypeOutputDtoBuilder categoryTypeId(Long categoryTypeId) {
            this.categoryTypeId = categoryTypeId;
            return this;
        }

        public CategoryTypeOutputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryTypeOutputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryTypeOutputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryTypeOutputDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryTypeOutputDto build() {
            return new CategoryTypeOutputDto(categoryTypeId, name, createdAt, updatedAt, description);
        }
    }
}
