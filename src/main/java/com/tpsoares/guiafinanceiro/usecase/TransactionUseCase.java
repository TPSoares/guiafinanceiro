package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.api.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.exceptions.TransactionNotFoundException;
import com.tpsoares.guiafinanceiro.gateway.TransactionGateway;
import com.tpsoares.guiafinanceiro.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransactionUseCase {

    private static final Boolean TRANSACTION_ENABLED = true;
    private final TransactionGateway transactionGateway;

    public TransactionUseCase(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    public List<TransactionDto> list() {
        return transactionGateway.findByEnabledOrderByTransactionDateDesc(TRANSACTION_ENABLED);
    }

    public TransactionDto get(Long transactionId) {
        return transactionGateway.findByTransactionIdAndEnabled(transactionId, TRANSACTION_ENABLED)
            .orElseThrow(TransactionNotFoundException::new);
    }

    public TransactionDto createTransaction(TransactionDto transactionDto) {
        return transactionGateway.create(transactionDto);
    }

    public TransactionDto updateTranasction(Long transactionId, TransactionDto transactionDto) {
        return transactionGateway.update(transactionId, transactionDto);
    }

    public List<TransactionByMonthDto> findTransactionTotalByMonth() {
        List<TransactionDto> transactionDtoList = list();

        if (transactionDtoList.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, List<TransactionDto>> groupedByMonth = transactionDtoList.stream()
            .collect(Collectors.groupingBy(transaction -> String.valueOf(transaction.getTransactionDate().getMonth())));

        return groupedByMonth.entrySet().stream()
            .map(entry -> {
                List<TransactionDto> transactions = entry.getValue();
                String monthDate = entry.getKey();
                BigDecimal monthlyExpense = transactions.stream()
                    .filter(transaction -> transaction.getCategoryType().getCategoryTypeId() == 2)
                    .map(transaction -> new BigDecimal(transaction.getTransactionValue()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
                BigDecimal monthlyIncome = transactions.stream()
                    .filter(transaction -> transaction.getCategoryType().getCategoryTypeId() == 1)
                    .map(transaction -> new BigDecimal(transaction.getTransactionValue()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

                return TransactionByMonthDto.builder()
                    .monthDate(monthDate)
                    .monthlyExpense(monthlyExpense.toString())
                    .monthlyIncome(monthlyIncome.toString())
                    .build();
            })
            .collect(Collectors.toList());
    }

    public List<TransactionMonthlyBySubCategoryTypeDto> findTransactionExpensesFromCurrentMonth() {
        List<TransactionDto> transactionDtoList = transactionGateway.findTransactionsFromCurrentMonth();

        Map<String, List<TransactionDto>> groupedBySubcategoryType = transactionDtoList.stream()
            .collect(Collectors.groupingBy(transaction -> transaction.getSubcategoryType().getDescription()));

        return groupedBySubcategoryType.entrySet().stream()
            .map(entry -> {
                List<TransactionDto> transactions = entry.getValue();
                String subcategoryType = entry.getKey();
                BigDecimal monthlyExpense = transactions.stream()
                    .filter(transaction -> Objects.equals(transaction.getSubcategoryType().getDescription(), subcategoryType))
                    .map(transaction -> new BigDecimal(transaction.getTransactionValue()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

                return TransactionMonthlyBySubCategoryTypeDto.builder()
                    .monthlyExpense(monthlyExpense.toString())
                    .subcategoryType(subcategoryType)
                    .build();
            })
            .collect(Collectors.toList());
    }
}
