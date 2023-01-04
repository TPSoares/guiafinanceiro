package com.tpsoares.guiafinanceiro.api.user.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.tpsoares.guiafinanceiro.api.user.User} entity
 */
public class UserInputDto implements Serializable {
    private final String name;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;

    public UserInputDto(String name, String email, Date createdAt, Date updatedAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
        UserInputDto entity = (UserInputDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ")";
    }

    public static UserInputDtoBuilder userInputDtoBuilder() {
        return new UserInputDtoBuilder();
    }

    public static final class UserInputDtoBuilder {
        private String name;
        private String email;
        private Date createdAt;
        private Date updatedAt;

        private UserInputDtoBuilder() {
        }

        public UserInputDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserInputDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserInputDtoBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserInputDtoBuilder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public UserInputDto build() {
            return new UserInputDto(name, email, createdAt, updatedAt);
        }
    }
}