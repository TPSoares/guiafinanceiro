package com.tpsoares.guiafinanceiro.gateway.impl;

import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.gateway.TransactionGateway;
import com.tpsoares.guiafinanceiro.mapper.TransactionMapper;
import com.tpsoares.guiafinanceiro.model.Transaction;
import com.tpsoares.guiafinanceiro.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TransactionGatewayImpl implements TransactionGateway {

    private final TransactionRepository transactionRepository;

    @Override
    public Optional<TransactionDto> findByTransactionIdAndEnabled(Long id, Boolean enabled) {
        return transactionRepository.findByTransactionIdAndEnabled(id, enabled)
            .map(TransactionMapper::toDomain);
    }

    @Override
    public List<TransactionDto> findByEnabledOrderByTransactionDateDesc(Boolean enabled) {
        return TransactionMapper.toOutputDtoList(transactionRepository.findByEnabledOrderByTransactionDateDesc(enabled));
    }

    @Override
    public List<TransactionDto> findTransactionsFromCurrentMonth() {
        return TransactionMapper.toOutputDtoList(transactionRepository.findTransactionsFromCurrentMonth());
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        return TransactionMapper.toDomain(transactionRepository.save(TransactionMapper.toEntitySave(transactionDto)));
    }

    @Override
    public TransactionDto update(Long transactionId, TransactionDto transactionDto) {
        return TransactionMapper.toDomain(transactionRepository.save(TransactionMapper.toEntityUpdate(transactionId, transactionDto)));
    }
}
