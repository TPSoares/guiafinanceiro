package com.tpsoares.guiafinanceiro.gateway;

import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;

import java.util.List;
import java.util.Optional;

public interface TransactionTypeGateway {

    Optional<TransactionTypeDto>  findById(Long transactionTypeId);
    List<TransactionTypeDto> findAll();
}
