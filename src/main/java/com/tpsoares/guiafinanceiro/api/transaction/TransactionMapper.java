package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeMapper;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.transaction.dto.*;
import com.tpsoares.guiafinanceiro.api.user.UserMapper;
import com.tpsoares.guiafinanceiro.api.user.dto.UserRequest;

import java.util.Date;
import java.util.List;

public class TransactionMapper {

    private TransactionMapper() {

    }

    public static List<TransactionResponse> toOutputDtoList(List<Transaction> transactionList) {
        return transactionList
                .stream()
                .map(transaction -> TransactionResponse.builder()
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

    public static TransactionResponse toDomain(Transaction transaction) {
        return TransactionResponse.builder()
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

    public static Transaction toEntitySave(TransactionRequest transactionRequest, UserRequest userRequest, CategoryTypeRequest categoryTypeRequest, SubcategoryTypeRequest subcategoryTypeRequest
                                           ) {
        return Transaction.builder()
            .name(transactionRequest.getName())
            .transactionDate(transactionRequest.getTransactionDate())
            .transactionValue(transactionRequest.getTransactionValue())
            .user(UserMapper.toEntity(userRequest))
            .categoryType(CategoryTypeMapper.toEntity(categoryTypeRequest))
            .subcategoryType(SubcategoryTypeMapper.toEntity(subcategoryTypeRequest))
            .enabled(true)
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();
    }

    public static Transaction toEntityUpdate(Long transactionId, TransactionRequest transactionRequest, UserRequest userRequest, CategoryTypeRequest categoryTypeRequest, SubcategoryTypeRequest subcategoryTypeRequest) {
        return Transaction.builder()
            .transactionId(transactionId)
            .name(transactionRequest.getName())
            .transactionDate(transactionRequest.getTransactionDate())
            .transactionValue(transactionRequest.getTransactionValue())
            .user(UserMapper.toEntity(userRequest))
            .categoryType(CategoryTypeMapper.toEntity(categoryTypeRequest))
            .subcategoryType(SubcategoryTypeMapper.toEntity(subcategoryTypeRequest))
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
