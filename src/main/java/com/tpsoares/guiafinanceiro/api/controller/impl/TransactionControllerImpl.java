package com.tpsoares.guiafinanceiro.api.controller.impl;

import com.tpsoares.guiafinanceiro.usecase.TransactionTypeUseCase;
import com.tpsoares.guiafinanceiro.api.controller.TransactionController;
import com.tpsoares.guiafinanceiro.usecase.CategoryTypeUseCase;
import com.tpsoares.guiafinanceiro.usecase.TransactionUseCase;
import com.tpsoares.guiafinanceiro.api.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionMonthlyByCategoryTypeDto;
import com.tpsoares.guiafinanceiro.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionControllerImpl implements TransactionController {

    private final TransactionUseCase transactionUseCase;
    private final UserUseCase userUseCase;
    private final TransactionTypeUseCase transactionTypeUseCase;
    private final CategoryTypeUseCase categoryTypeUseCase;

    @Override
    public List<TransactionDto> list() {
        return transactionUseCase.list();
    }

    @Override
    public TransactionDto get(Long transactionId) {
        return transactionUseCase.get(transactionId);
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        userUseCase.getUser(transactionDto.getUser().getUserId());
        transactionTypeUseCase.getTransactionType(transactionDto.getTransactionType().getTransactionTypeId());
        categoryTypeUseCase.getCategoryType(transactionDto.getCategoryType().getCategoryTypeId());

        return transactionUseCase.createTransaction(transactionDto);
    }

    @Override
    public TransactionDto update(Long transactionId, TransactionDto transactionDto) {

        transactionUseCase.get(transactionId);
        userUseCase.getUser(transactionDto.getUser().getUserId());
        transactionTypeUseCase.getTransactionType(transactionDto.getTransactionType().getTransactionTypeId());
        categoryTypeUseCase.getCategoryType(transactionDto.getCategoryType().getCategoryTypeId());

        return transactionUseCase.updateTranasction(transactionId, transactionDto);

    }

    @Override
    public List<TransactionByMonthDto> findTransactionTotalByMonth() {
        return transactionUseCase.findTransactionTotalByMonth();
    }

    @Override
    public List<TransactionMonthlyByCategoryTypeDto> findTransactionMonthlyByCategory() {
        return transactionUseCase.findTransactionExpensesFromCurrentMonth();
    }
}
