package com.tpsoares.guiafinanceiro.api.exceptions;

import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends ApiKnownException {

    public TransactionNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.TRANSACTION_NOT_FOUND.getValue(), ErrorMessages.TRANSACTION_NOT_FOUND.getValue(), new Date(), null);
    }
}
