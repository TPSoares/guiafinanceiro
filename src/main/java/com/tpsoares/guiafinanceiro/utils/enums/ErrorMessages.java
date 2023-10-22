package com.tpsoares.guiafinanceiro.utils.enums;

public enum ErrorMessages {
    TRANSACTION_NOT_FOUND("Transaction not found"),
    TRANSACTION_TYPE_NOT_FOUND("Transaction type not found"),
    CATEGORY_TYPE_NOT_FOUND("Category type not found"),
    USER_NOT_FOUND("User not found"),
    INVALID_FIELD("Invalid field"),
    INTERNAL_SERVER_ERROR("Internal server error");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
