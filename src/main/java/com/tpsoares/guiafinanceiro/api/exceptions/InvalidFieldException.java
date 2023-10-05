package com.tpsoares.guiafinanceiro.api.exceptions;

import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends ApiKnownException {

    public InvalidFieldException() {
        super(HttpStatus.BAD_REQUEST, ErrorCodes.INVALID_FIELD.getValue(), ErrorMessages.INVALID_FIELD.getValue(), new Date(), null);
    }
}
