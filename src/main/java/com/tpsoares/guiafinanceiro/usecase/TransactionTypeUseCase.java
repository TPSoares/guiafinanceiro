package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.mapper.TransactionTypeMapper;
import com.tpsoares.guiafinanceiro.repository.TransactionTypeRepository;
import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;
import com.tpsoares.guiafinanceiro.exceptions.TransactionTypeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeUseCase {

    TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeUseCase(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionTypeDto getTransactionType(Long transactionTypeId) {
        return transactionTypeRepository.findById(transactionTypeId)
            .map(TransactionTypeMapper::toDomain)
            .orElseThrow(TransactionTypeNotFoundException::new);
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
