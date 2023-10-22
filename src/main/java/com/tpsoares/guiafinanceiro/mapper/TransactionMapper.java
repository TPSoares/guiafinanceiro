package com.tpsoares.guiafinanceiro.mapper;

import com.tpsoares.guiafinanceiro.api.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionMonthlyByCategoryTypeDto;
import com.tpsoares.guiafinanceiro.model.Transaction;

import java.util.Date;
import java.util.List;

public class TransactionMapper {

    private TransactionMapper() {

    }

    public static List<TransactionDto> toOutputDtoList(List<Transaction> transactionList) {
        return transactionList
                .stream()
                .map(transaction -> TransactionDto.builder()
                        .transactionId(transaction.getTransactionId())
                        .name(transaction.getName())
                        .transactionValue(transaction.getTransactionValue())
                        .createdAt(transaction.getCreatedAt())
                        .updatedAt(transaction.getUpdatedAt())
                        .transactionDate(transaction.getTransactionDate())
                        .user(UserMapper.toDomain(transaction.getUser()))
                        .transactionType(TransactionTypeMapper.toDomain(transaction.getTransactionType()))
                        .categoryType(CategoryTypeMapper.toDomain(transaction.getCategoryType()))
                        .build())
                .toList();
    }

    public static TransactionDto toDomain(Transaction transaction) {
        return TransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .name(transaction.getName())
                .transactionValue(transaction.getTransactionValue())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .transactionDate(transaction.getTransactionDate())
                .transactionType(TransactionTypeMapper.toDomain(transaction.getTransactionType()))
                .categoryType(CategoryTypeMapper.toDomain(transaction.getCategoryType()))
                .user(UserMapper.toDomain(transaction.getUser()))
                .build();
    }

    public static Transaction toEntitySave(TransactionDto transactionDto) {
        return Transaction.builder()
            .name(transactionDto.getName())
            .transactionDate(transactionDto.getTransactionDate())
            .transactionValue(transactionDto.getTransactionValue())
            .user(UserMapper.toEntity(transactionDto.getUser()))
            .transactionType(TransactionTypeMapper.toEntity(transactionDto.getTransactionType()))
            .categoryType(CategoryTypeMapper.toEntity(transactionDto.getCategoryType()))
            .enabled(true)
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();
    }

    public static Transaction toEntityUpdate(Long transactionId, TransactionDto transactionDto) {
        return Transaction.builder()
            .transactionId(transactionId)
            .name(transactionDto.getName())
            .transactionDate(transactionDto.getTransactionDate())
            .transactionValue(transactionDto.getTransactionValue())
            .user(UserMapper.toEntity(transactionDto.getUser()))
            .transactionType(TransactionTypeMapper.toEntity(transactionDto.getTransactionType()))
            .categoryType(CategoryTypeMapper.toEntity(transactionDto.getCategoryType()))
            .enabled(true)
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();
    }
}
