package com.tpsoares.guiafinanceiro.api.controller;

import com.tpsoares.guiafinanceiro.api.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionMonthlyByCategoryTypeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transactions")
public interface TransactionController {

    @GetMapping()
    List<TransactionDto> list();

    @GetMapping("/{transactionId}")
    TransactionDto get(@PathVariable Long transactionId);

    @PostMapping()
    TransactionDto create(@RequestBody TransactionDto transactionDto);

    @PutMapping("/{transactionId}")
    TransactionDto update(@PathVariable Long transactionId, @RequestBody TransactionDto transactionDto);

    @GetMapping("/monthly")
    List<TransactionByMonthDto> findTransactionTotalByMonth();

    @GetMapping("/monthly-by-category")
    List<TransactionMonthlyByCategoryTypeDto> findTransactionMonthlyByCategory();
}
