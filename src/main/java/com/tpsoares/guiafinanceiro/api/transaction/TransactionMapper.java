package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;
import com.tpsoares.guiafinanceiro.api.user.UserMapper;

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
                        .user(UserMapper.toTransactionOutPutDto(transaction.getUser()))
                        .categoryType(CategoryTypeMapper.toTransactionOutPutDto(transaction.getCategoryType()))
                        .subcategoryType(SubcategoryTypeMapper.toTransactionOutPutDto(transaction.getSubcategoryType()))
                        .build())
                .toList();
    }

    public static TransactionOutputDto toOutputDto(Transaction transaction) {
        return TransactionOutputDto.builder()
                .transactionId(transaction.getTransactionId())
                .name(transaction.getName())
                .transactionValue(transaction.getTransactionValue())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .categoryType(transaction.getCategoryType())
                .subcategoryType(transaction.getSubcategoryType())
                .build();
    }
}
