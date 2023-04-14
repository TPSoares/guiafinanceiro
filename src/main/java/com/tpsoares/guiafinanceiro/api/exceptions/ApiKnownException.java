package com.tpsoares.guiafinanceiro.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tpsoares.guiafinanceiro.utils.ErrorDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiKnownException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String code;
    private final String errorMessage;
    private final Date timeStamp;
    private final ErrorDetail detail;
}
