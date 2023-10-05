package com.tpsoares.guiafinanceiro.api.exceptions;

import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Date;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryTypeNotFoundException extends ApiKnownException {

    public CategoryTypeNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.CATEGORY_TYPE_NOT_FOUND.getValue(), ErrorMessages.CATEGORY_TYPE_NOT_FOUND.getValue(), new Date(), null);
    }
}
