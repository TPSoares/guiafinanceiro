package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionRequest;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/transactions")
public interface TransactionController {

    @GetMapping()
    List<TransactionResponse> list();

    @GetMapping("/{transactionId}")
    TransactionResponse get(@PathVariable Long transactionId);

    @PostMapping()
    TransactionResponse create(@RequestBody TransactionRequest transactionInputDto);

    @PutMapping("/{transactionId}")
    TransactionResponse update(@PathVariable Long transactionId, @RequestBody TransactionRequest transactionInputDto);

    @GetMapping("/monthly")
    List<TransactionByMonthDto> findTransactionTotalByMonth();

    @GetMapping("/monthly-by-subcategory")
    List<TransactionMonthlyBySubCategoryTypeDto> findTransactionMonthlyBySubCategory();
}
