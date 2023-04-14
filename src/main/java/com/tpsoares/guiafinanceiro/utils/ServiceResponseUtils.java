package com.tpsoares.guiafinanceiro.utils;

import com.tpsoares.guiafinanceiro.api.exceptions.ApiKnownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServiceResponseUtils {

    public <T> ResponseEntity<Object> responseEntitySuccess(T dto, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .body(dto);
    }
    public <T> ResponseEntity<Object> responseEntityError(T response) {
        if (response instanceof ApiKnownException) {
            return ResponseEntity.status(((ApiKnownException) response).getHttpStatus()).body(
                    new ResponseError.ResponseErrorBuilder()
                            .code(((ApiKnownException) response).getCode())
                            .detail(((ApiKnownException) response).getDetail())
                            .errorMessage(((ApiKnownException) response).getErrorMessage())
                            .timeStamp(((ApiKnownException) response).getTimeStamp())
                            .build());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseError.ResponseErrorBuilder()
                        .timeStamp(new Date())
                        .errorMessage("Internal server error")
                        .build());
    }
}
