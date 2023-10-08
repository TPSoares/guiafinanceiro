package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.api.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.exceptions.TransactionNotFoundException;
import com.tpsoares.guiafinanceiro.gateway.TransactionGateway;
import com.tpsoares.guiafinanceiro.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
