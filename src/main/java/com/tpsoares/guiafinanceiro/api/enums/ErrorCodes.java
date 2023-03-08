package com.tpsoares.guiafinanceiro.api.enums;

public enum ErrorCodes {
    TRANSACTION_NOT_FOUND("422000"),
    CATEGORY_TYPE_NOT_FOUND("422001"),
    SUBCATEGORY_TYPE_NOT_FOUND("422002"),
    USER_NOT_FOUND("422003"),
    INVALID_FIELD("400000"),
    INTERNAL_SERVER_ERROR("500000")
    ;

    private final String value;

    ErrorCodes(String value) {
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
