package com.tpsoares.guiafinanceiro.mapper;

import com.tpsoares.guiafinanceiro.api.dto.TransactionTypeDto;
import com.tpsoares.guiafinanceiro.model.TransactionType;

import java.util.List;

public class TransactionTypeMapper {

    public static TransactionType toTransactionOutPutDto(TransactionType transactionType) {
        return TransactionType.builder()
                .transactionTypeId(transactionType.getTransactionTypeId())
                .description(transactionType.getDescription())
                .name(transactionType.getName())
                .build();
    }

    public static TransactionType toEntity(TransactionTypeDto transactionTypeDto) {
        return TransactionType.builder()
            .transactionTypeId(transactionTypeDto.getTransactionTypeId())
            .description(transactionTypeDto.getDescription())
            .name(transactionTypeDto.getName())
            .build();
    }

    public static TransactionTypeDto toDomain(TransactionType transactionType) {
        return TransactionTypeDto.builder()
            .transactionTypeId(transactionType.getTransactionTypeId())
            .description(transactionType.getDescription())
            .name(transactionType.getName())
            .build();
    }

    public static List<TransactionTypeDto> toTransactionTypeList(List<TransactionType> transactionTypeList) {
        return transactionTypeList
            .stream()
            .map(transactionType -> TransactionTypeDto.builder()
                .transactionTypeId(transactionType.getTransactionTypeId())
                .name(transactionType.getName())
                .updatedAt(transactionType.getUpdatedAt())
                .createdAt(transactionType.getCreatedAt())
                .description(transactionType.getDescription())
                .build())
            .toList();
    }
}
