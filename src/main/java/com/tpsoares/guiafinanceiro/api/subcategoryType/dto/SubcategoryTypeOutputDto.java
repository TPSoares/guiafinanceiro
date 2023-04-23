package com.tpsoares.guiafinanceiro.api.subcategoryType.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType} entity
 */
public class SubcategoryTypeOutputDto implements Serializable {
    private final Long subcategoryTypeId;
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;
    private final String description;

    public SubcategoryTypeOutputDto(Long subcategoryTypeId, String name, Date createdAt, Date updatedAt, String description) {
        this.subcategoryTypeId = subcategoryTypeId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
    }

    public Long getSubcategoryTypeId() {
        return subcategoryTypeId;
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
        SubcategoryTypeOutputDto entity = (SubcategoryTypeOutputDto) o;
        return Objects.equals(this.subcategoryTypeId, entity.subcategoryTypeId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subcategoryTypeId, name, createdAt, description, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "subcategoryTypeId = " + subcategoryTypeId + ", " +
                "name = " + name + ", " +
                "createdAt = " + createdAt + ", " +
                "description = " + description + ", " +
                "updatedAt = " + updatedAt + ")";
    }

    public static SubcategoryTypeOutputDtoBuilder subcategoryTypeOutputDtoBuilder() {
        return new SubcategoryTypeOutputDtoBuilder();
    }

    public static final class SubcategoryTypeOutputDtoBuilder {
        private Long subcategoryTypeId;
        private String name;
        private Date createdAt;
        private Date updatedAt;
        private String description;

        private SubcategoryTypeOutputDtoBuilder() {
        }

        public SubcategoryTypeOutputDtoBuilder subcategoryTypeId(Long subcategoryTypeId) {
            this.subcategoryTypeId = subcategoryTypeId;
            return this;
        }

        public SubcategoryTypeOutputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SubcategoryTypeOutputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SubcategoryTypeOutputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public SubcategoryTypeOutputDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public SubcategoryTypeOutputDto build() {
            return new SubcategoryTypeOutputDto(subcategoryTypeId, name, createdAt, updatedAt, description);
        }
    }
}
