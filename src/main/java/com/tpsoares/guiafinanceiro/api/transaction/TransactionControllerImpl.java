package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeUseCase;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeUseCase;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionControllerImpl implements TransactionController {

    private final TransactionUseCase transactionUseCase;
    private final UserUseCase userUseCase;
    private final CategoryTypeUseCase categoryTypeUseCase;
    private final SubcategoryTypeUseCase subcategoryTypeUseCase;

    @Override
    public List<TransactionDto> list() {
        return transactionUseCase.list();
    }

    @Override
    public TransactionDto get(Long transactionId) {
        return transactionUseCase.get(transactionId);
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        userUseCase.getUser(transactionDto.getUser().getUserId());
        categoryTypeUseCase.getCategoryType(transactionDto.getCategoryType().getCategoryTypeId());
        subcategoryTypeUseCase.getSubCategoryType(transactionDto.getSubcategoryType().getSubcategoryTypeId());

        return transactionUseCase.createTransaction(transactionDto);
    }

    @Override
    public TransactionDto update(Long transactionId, TransactionDto transactionDto) {

        transactionUseCase.get(transactionId);
        userUseCase.getUser(transactionDto.getUser().getUserId());
        categoryTypeUseCase.getCategoryType(transactionDto.getCategoryType().getCategoryTypeId());
        subcategoryTypeUseCase.getSubCategoryType(transactionDto.getSubcategoryType().getSubcategoryTypeId());

        return transactionUseCase.updateTranasction(transactionId, transactionDto);

    }

    @Override
    public List<TransactionByMonthDto> findTransactionTotalByMonth() {
        return null;
    }

    @Override
    public List<TransactionMonthlyBySubCategoryTypeDto> findTransactionMonthlyBySubCategory() {
        return null;
    }
}
