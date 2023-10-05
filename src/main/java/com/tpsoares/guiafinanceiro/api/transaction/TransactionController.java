package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/transactions")
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

    @GetMapping("/monthly-by-subcategory")
    List<TransactionMonthlyBySubCategoryTypeDto> findTransactionMonthlyBySubCategory();
}
