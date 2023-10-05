package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.exceptions.TransactionNotFoundException;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionUseCase {

    private static final Boolean TRANSACTION_ENABLED = true;

    private final TransactionRepository transactionRepository;

    public TransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDto> list() {
        return TransactionMapper.toOutputDtoList(transactionRepository.findByEnabledOrderByTransactionDateDesc(TRANSACTION_ENABLED));
    }

    public TransactionDto get(Long transactionId) {
        return transactionRepository.findByTransactionIdAndEnabled(transactionId, TRANSACTION_ENABLED)
            .map(TransactionMapper::toDomain)
            .orElseThrow(TransactionNotFoundException::new);
    }

    public TransactionDto createTransaction(TransactionDto transactionDto) {
        return TransactionMapper.toDomain(transactionRepository.save(TransactionMapper.toEntitySave(transactionDto)));
    }

    public TransactionDto updateTranasction(Long transactionId, TransactionDto transactionDto) {
        return TransactionMapper.toDomain(transactionRepository.save(TransactionMapper.toEntityUpdate(transactionId, transactionDto)));
    }
//
//    public Result<Transaction.TransactionBuilder, Exception> checkInputDtoAndReturnBuilder(TransactionInputDto transactionInputDto) {
//
//        if (transactionInputDto == null) {
//            return Result.error(new InvalidFieldException());
//        }
//
//        return Result.success(TransactionMapper.inputMap(transactionInputDto));
//    }
//
//    Result<Transaction.TransactionBuilder, Exception> getTransaction(Transaction.TransactionBuilder transactionBuilder, Long transactionId) {
//        try {
//
//            if (transactionId != null) {
//                Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);
//
//                if (transactionOptional.isEmpty()) {
//                    return Result.error(new TransactionNotFoundException());
//                }
//            }
//
//            transactionBuilder.transactionId(transactionId);
//
//            return Result.success(transactionBuilder);
//
//        } catch (Exception e) {
//            return Result.error(e);
//        }
//    }
//
//    public Result<List<TransactionByMonthDto>, ResponseError> findTransactionTotalByMonth() {
//
//        try {
//
//            List<Object[]> result = transactionRepository.findTransactionTotalByMonth();
//
//            List<TransactionByMonthDto> transactionByMonthDtoList = TransactionMapper.toTransactionByMonthDto(result);
//
//            return Result.success(transactionByMonthDtoList);
//
//        } catch (Exception e) {
//            return Result.error(ResponseError.builder()
//                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
//                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
//                    .build());
//        }
//    }
//
//    public Result<List<TransactionMonthlyBySubCategoryTypeDto>, Exception> findTransactionMonthlyBySubCategory() {
//        try {
//
//            List<Object[]> result = transactionRepository.findMonthlyExpensesBySubCategoryType();
//
//            List<TransactionMonthlyBySubCategoryTypeDto> transactionMonthlyBySubCategoryTypeDtoList = TransactionMapper.toTransactionMonthlyBySubCategoryTypeDto(result);
//
//            return Result.success(transactionMonthlyBySubCategoryTypeDtoList);
//
//        } catch (Exception e) {
//            return Result.error(e);
//        }
//    }
}
