package com.tpsoares.guiafinanceiro.api.user.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.user.User} entity
 */
public class UserOutputDto implements Serializable {
    private final Long userId;
    private final String name;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;

    public UserOutputDto(Long userId, String name, String email, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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
        UserOutputDto entity = (UserOutputDto) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "userId = " + userId + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }

    public static UserOutputDtoBuilder userOutputDtoBuilder() {
        return new UserOutputDtoBuilder();
    }

    public static final class UserOutputDtoBuilder {
        private Long userId;
        private String name;
        private String email;
        private Date createdAt;
        private Date updatedAt;

        private UserOutputDtoBuilder() {
        }

        public UserOutputDtoBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserOutputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserOutputDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserOutputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserOutputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public UserOutputDto build() {
            return new UserOutputDto(userId, name, email, createdAt, updatedAt);
        }
    }
}