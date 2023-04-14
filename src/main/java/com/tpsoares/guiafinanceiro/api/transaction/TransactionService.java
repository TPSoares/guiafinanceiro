package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import com.tpsoares.guiafinanceiro.api.exceptions.InvalidFieldException;
import com.tpsoares.guiafinanceiro.api.exceptions.TransactionNotFoundException;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;
import com.tpsoares.guiafinanceiro.api.user.User;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private static final Boolean TRANSACTION_ENABLED = true;

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Result<List<TransactionOutputDto>, Exception> list() {

        try {
            List<Transaction> transactionList = transactionRepository.findByEnabled(TRANSACTION_ENABLED);

            List<TransactionOutputDto> transactionOutputDtoList = TransactionMapper.toOutputDtoList(transactionList);

            return Result.success(transactionOutputDtoList);

        } catch (Exception e) {
            return Result.error(e);
        }
    }

    public Result<TransactionOutputDto, Exception> get(Long transactionId) {
        try {

            return findByTransactionIdAndEnabled(transactionId)
                    .flatMap(this::mapTransactionToOutputDto);

        } catch (Exception e) {
            return Result.error(e);
        }
    }

    private Result<TransactionOutputDto, Exception> mapTransactionToOutputDto(Transaction transaction) {
        TransactionOutputDto transactionOutputDto = TransactionMapper.toOutputDto(transaction);
        return Result.success(transactionOutputDto);
    }

    private Result<Transaction, Exception> findByTransactionIdAndEnabled(Long transactionId) {
        try {
            Transaction transaction = transactionRepository.findByTransactionIdAndEnabled(transactionId, TRANSACTION_ENABLED);

            if (transaction == null) {
                return Result.error(new TransactionNotFoundException());
            }

            return Result.success(transaction);

        } catch (Exception e) {
            return Result.error(new Exception());
        }
    }

    public Result<TransactionOutputDto, Exception> saveTransaction(Transaction.TransactionBuilder transactionBuilder) {

        try {
            return Result.success(TransactionMapper.toOutputDto(transactionRepository.save(transactionBuilder.build())));
        } catch (Exception e) {
            return Result.error(e);
        }
    }

    public Result<Transaction.TransactionBuilder, Exception> checkInputDtoAndReturnBuilder(TransactionInputDto transactionInputDto) {

        if (transactionInputDto == null) {
            return Result.error(new InvalidFieldException());
        }

        return Result.success(TransactionMapper.inputMap(transactionInputDto));
    }

    Result<Transaction.TransactionBuilder, Exception> getTransaction(Transaction.TransactionBuilder transactionBuilder, Long transactionId) {
        try {

            if (transactionId != null) {
                Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);

                if (transactionOptional.isEmpty()) {
                    return Result.error(new TransactionNotFoundException());
                }
            }

            transactionBuilder.transactionId(transactionId);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(e);
        }
    }

    public Result<List<TransactionByMonthDto>, ResponseError> findTransactionTotalByMonth() {

        try {

            List<Object[]> result = transactionRepository.findTransactionTotalByMonth();

            List<TransactionByMonthDto> transactionByMonthDtoList = TransactionMapper.toTransactionByMonthDto(result);

            return Result.success(transactionByMonthDtoList);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    public Result<List<TransactionMonthlyBySubCategoryTypeDto>, Exception> findTransactionMonthlyBySubCategory() {
        try {

            List<Object[]> result = transactionRepository.findMonthlyExpensesBySubCategoryType();

            List<TransactionMonthlyBySubCategoryTypeDto> transactionMonthlyBySubCategoryTypeDtoList = TransactionMapper.toTransactionMonthlyBySubCategoryTypeDto(result);

            return Result.success(transactionMonthlyBySubCategoryTypeDtoList);

        } catch (Exception e) {
            return Result.error(e);
        }
    }
}
