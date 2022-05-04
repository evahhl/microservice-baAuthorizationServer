package com.nartan.ba.resource.enums;

public enum ResultCode {

    SUCCESS("000"),
    INVALID_PARAM("001"),
    REQUIRED_PARAM("002"),
    USER_NOT_FOUND("019"),
    TOKEN_ERROR("028"),
    ACCOUNT_NOT_FOUND("030"),
    DATABASE_ERROR("033"),
    AUTHORIZATION_NOT_FOUND("034"),
    COULD_NOT_CREATE("039"),
    ACCESS_DENIED("099"),
    OPERATION_FAILED("100"),
    RECORD_NOT_FOUND("102"),
    DUPLICATED("103"),
    GATEWAY_TIMEOUT("131"),
    GATEWAY_ERROR("132"),
    GATEWAY_UNKNOWN("133"),
    RESOURCE_NOT_FOUND("998"),
    UNKNOWN("999");

    private final String code;

    private ResultCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
