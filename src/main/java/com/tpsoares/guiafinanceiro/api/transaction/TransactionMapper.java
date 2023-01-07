package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    public static List<TransactionOutputDto> toOutputDtoList(List<Transaction> transactionList) {
        return transactionList
                .stream()
                .map(transaction -> TransactionOutputDto.builder()
                        .transactionId(transaction.getTransactionId())
                        .name(transaction.getName())
                        .transactionValue(transaction.getTransactionValue())
                        .createdAt(transaction.getCreatedAt())
                        .updatedAt(transaction.getUpdatedAt())
                        .user(transaction.getUser())
                        .categoryType(transaction.getCategoryType())
                        .subcategoryType(transaction.getSubcategoryType())
                        .build())
                .collect(Collectors.toList());
    }
}
