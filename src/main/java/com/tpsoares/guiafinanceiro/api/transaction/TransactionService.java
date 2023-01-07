package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Result<List<TransactionOutputDto>, ResponseError> list() {

        try {
            List<Transaction> transactionList = transactionRepository.findAll();

            List<TransactionOutputDto> transactionOutputDtoList = transactionList
                    .stream()
                    .map(transaction -> TransactionOutputDto.transactionOutputDtoBuilder()
                            .transactionId(transaction.getTransactionId())
                            .name(transaction.getName())
                            .createdAt(transaction.getCreatedAt())
                            .build())
                    .collect(Collectors.toList());

            return Result.success(transactionOutputDtoList);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .code("400001")
                            .build());
        }
    }
}
