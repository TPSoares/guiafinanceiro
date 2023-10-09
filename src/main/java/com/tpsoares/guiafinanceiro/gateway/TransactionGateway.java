package com.tpsoares.guiafinanceiro.gateway;

import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionGateway {
    Optional<TransactionDto> findByTransactionIdAndEnabled(Long id, Boolean enabled);
    List<TransactionDto> findByEnabledOrderByTransactionDateDesc(Boolean enabled);

    List<TransactionDto> findTransactionsFromCurrentMonth();

    TransactionDto create(TransactionDto transactionDto);

    TransactionDto update(Long transactionId, TransactionDto transactionDto);
}
