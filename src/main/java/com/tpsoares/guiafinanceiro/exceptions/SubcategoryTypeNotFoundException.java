package com.tpsoares.guiafinanceiro.exceptions;

import com.tpsoares.guiafinanceiro.utils.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.utils.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SubcategoryTypeNotFoundException extends ApiKnownException {

    public SubcategoryTypeNotFoundException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.SUBCATEGORY_TYPE_NOT_FOUND.getValue(), ErrorMessages.SUBCATEGORY_TYPE_NOT_FOUND.getValue(), new Date(), null);
    }
}