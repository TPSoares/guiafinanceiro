package com.tpsoares.guiafinanceiro.api.controller.impl;

import com.tpsoares.guiafinanceiro.api.controller.TransactionTypeController;
import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;
import com.tpsoares.guiafinanceiro.usecase.TransactionTypeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionTypeControllerImpl implements TransactionTypeController {

    private final TransactionTypeUseCase transactionTypeUseCase;

    @Override
    public List<TransactionTypeDto> list() {
        return null;
    }
}
