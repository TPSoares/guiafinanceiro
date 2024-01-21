package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.gateway.TransactionTypeGateway;
import com.tpsoares.guiafinanceiro.mapper.TransactionTypeMapper;
import com.tpsoares.guiafinanceiro.repository.TransactionTypeRepository;
import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;
import com.tpsoares.guiafinanceiro.exceptions.TransactionTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeUseCase {

    TransactionTypeGateway transactionTypeGateway;

    public TransactionTypeUseCase(TransactionTypeGateway transactionTypeGateway) {
        this.transactionTypeGateway = transactionTypeGateway;
    }

    public TransactionTypeDto getTransactionType(Long transactionTypeId) {
        return transactionTypeGateway.findById(transactionTypeId)
            .orElseThrow(TransactionTypeNotFoundException::new);
    }

    public List<TransactionTypeDto> list() {
        return transactionTypeGateway.findAll();
    }
//
//    public Result<List<CategoryTypeOutputDto>, Exception> list() {
//
//        try {
//            return Result.success(CategoryTypeMapper.toCategoryTypeList(categoryTypeRepository.findAll()));
//        } catch (Exception e) {
//            return Result.error(e);
//        }
//    }
}
