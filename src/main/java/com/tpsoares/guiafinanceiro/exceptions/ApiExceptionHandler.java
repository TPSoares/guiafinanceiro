package com.tpsoares.guiafinanceiro.exceptions;

import com.tpsoares.guiafinanceiro.utils.responses.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiKnownException.class)
    public ResponseEntity<ResponseError> handleException(ApiKnownException apiKnownException) {
        return ResponseEntity
            .status(apiKnownException.getHttpStatus())
            .body(ResponseError.builder()
                .code(apiKnownException.getCode())
                .detail(apiKnownException.getDetail())
                .errorMessage(apiKnownException.getErrorMessage())
                .timeStamp(apiKnownException.getTimeStamp())
                .build()
            );
    }
}
