package com.tpsoares.guiafinanceiro.api.subcategoryType.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType} entity
 */
public class SubcategoryTypeInputDto implements Serializable {
    private final String name;
    private final Date createdAt;
    private final Date updatedAt;

    public SubcategoryTypeInputDto(String name, Date createdAt, Date updatedAt) {
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
        SubcategoryTypeInputDto entity = (SubcategoryTypeInputDto) o;
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

    public static SubcategoryTypeInputDtoBuilder subcategoryTypeInputDtoBuilder() {
        return new SubcategoryTypeInputDtoBuilder();
    }

    public static final class SubcategoryTypeInputDtoBuilder {
        private String name;
        private Date createdAt;
        private Date updatedAt;

        private SubcategoryTypeInputDtoBuilder() {
        }

        public SubcategoryTypeInputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SubcategoryTypeInputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SubcategoryTypeInputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public SubcategoryTypeInputDto build() {
            return new SubcategoryTypeInputDto(name, createdAt, updatedAt);
        }
    }
}