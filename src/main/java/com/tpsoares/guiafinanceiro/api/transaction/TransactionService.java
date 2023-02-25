package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private static final Boolean TRANSACTION_ENABLED = true;

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Result<List<TransactionOutputDto>, ResponseError> list() {

        try {
            List<Transaction> transactionList = transactionRepository.findByEnabled(TRANSACTION_ENABLED);

            List<TransactionOutputDto> transactionOutputDtoList = TransactionMapper.toOutputDtoList(transactionList);

            return Result.success(transactionOutputDtoList);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .code("400001")
                            .build());
        }
    }

    public Result<TransactionOutputDto, ResponseError> get(Long transactionId) {
        try {

            return findByTransactionIdAndEnabled(transactionId)
                    .flatMap(this::mapTransactionToOutputDto);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }

    private Result<TransactionOutputDto, ResponseError> mapTransactionToOutputDto(Transaction transaction) {
        TransactionOutputDto transactionOutputDto = TransactionMapper.toOutputDto(transaction);
        return Result.success(transactionOutputDto);
    }

    private Result<Transaction, ResponseError> findByTransactionIdAndEnabled(Long transactionId) {
        try {
            Transaction transaction = transactionRepository.findByTransactionIdAndEnabled(transactionId, TRANSACTION_ENABLED);

            if (transaction == null) {
                return Result.error(ResponseError.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .code("400002")
                        .errorMessage("Transaction not found.")
                        .build());
            }

            return Result.success(transaction);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }
}
