package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.user.UserMapper;

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
                        .categoryType(CategoryTypeMapper.toDomain(transaction.getCategoryType()))
                        .subcategoryType(SubcategoryTypeMapper.toDomain(transaction.getSubcategoryType()))
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
                .categoryType(CategoryTypeMapper.toDomain(transaction.getCategoryType()))
                .subcategoryType(SubcategoryTypeMapper.toDomain(transaction.getSubcategoryType()))
                .user(UserMapper.toDomain(transaction.getUser()))
                .build();
    }

    public static Transaction toEntitySave(TransactionDto transactionDto) {
        return Transaction.builder()
            .name(transactionDto.getName())
            .transactionDate(transactionDto.getTransactionDate())
            .transactionValue(transactionDto.getTransactionValue())
            .user(UserMapper.toEntity(transactionDto.getUser()))
            .categoryType(CategoryTypeMapper.toEntity(transactionDto.getCategoryType()))
            .subcategoryType(SubcategoryTypeMapper.toEntity(transactionDto.getSubcategoryType()))
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
            .categoryType(CategoryTypeMapper.toEntity(transactionDto.getCategoryType()))
            .subcategoryType(SubcategoryTypeMapper.toEntity(transactionDto.getSubcategoryType()))
            .enabled(true)
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();
    }

//    public static Transaction toEntityUpdate(Long transactionId, TransactionDto transactionDto) {
//        return Transaction.builder()
//                .transactionId(transactionId)
//                .name(transactionDto.getName())
//                .transactionDate(transactionDto.getTransactionDate())
//                .transactionValue(transactionDto.getTransactionValue())
//                .categoryType(transactionInputDto.getCategoryType())
//                .subcategoryType(transactionInputDto.getSubcategoryType())
//                .user(transactionInputDto.getUser())
//                .enabled(true)
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build();
//    }

    public static List<TransactionByMonthDto> toTransactionByMonthDto(List<Object[]> result) {
        return result
                .stream()
                .map(transaction -> TransactionByMonthDto.builder()
                    .monthlyExpense(transaction[0].toString())
                    .monthlyIncome(transaction[1].toString())
                    .monthDate(transaction[2].toString())
                    .build())
                .toList();
    }

    public static List<TransactionMonthlyBySubCategoryTypeDto> toTransactionMonthlyBySubCategoryTypeDto(List<Object[]> result) {
        return result
                .stream()
                .map(transaction -> TransactionMonthlyBySubCategoryTypeDto.builder()
                        .monthlyExpense(transaction[0].toString())
                        .subcategoryType(transaction[1].toString())
                        .build())
                .toList();
    }



}
