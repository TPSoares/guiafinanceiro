package com.tpsoares.guiafinanceiro.gateway.impl;

import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;
import com.tpsoares.guiafinanceiro.exceptions.TransactionTypeNotFoundException;
import com.tpsoares.guiafinanceiro.gateway.TransactionTypeGateway;
import com.tpsoares.guiafinanceiro.mapper.TransactionTypeMapper;
import com.tpsoares.guiafinanceiro.repository.TransactionTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TransactionTypeGatewayImpl implements TransactionTypeGateway {

    private final TransactionTypeRepository transactionTypeRepository;

    @Override
    public Optional<TransactionTypeDto> findById(Long transactionTypeId) {
        return transactionTypeRepository.findById(transactionTypeId)
            .map(TransactionTypeMapper::toDomain);
    }
    @Override
    public List<TransactionTypeDto> findAll() {
        return transactionTypeRepository.findAll()
            .stream()
            .map(TransactionTypeMapper::toDomain)
            .toList();
    }
}
