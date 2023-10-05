package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeUseCase;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeResponse;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeUseCase;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeRequest;
import com.tpsoares.guiafinanceiro.api.subcategoryType.dto.SubcategoryTypeResponse;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionRequest;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionResponse;
import com.tpsoares.guiafinanceiro.api.user.UserUseCase;
import com.tpsoares.guiafinanceiro.api.user.dto.UserRequest;
import com.tpsoares.guiafinanceiro.api.user.dto.UserResponse;
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
    public List<TransactionResponse> list() {
        return transactionUseCase.list();
    }

    @Override
    public TransactionResponse get(Long transactionId) {
        return transactionUseCase.get(transactionId);
    }

    @Override
    public TransactionResponse create(TransactionRequest transactionRequest) {
        UserResponse userResponse = userUseCase.getUser(transactionRequest.getUserId());
        CategoryTypeResponse categoryTypeResponse = categoryTypeUseCase.getCategoryType(transactionRequest.getCategoryTypeId());
        SubcategoryTypeResponse subcategoryTypeResponse = subcategoryTypeUseCase.getSubCategoryType(transactionRequest.getSubcategoryTypeId());

        UserRequest userRequest = UserRequest.builder()
            .userId(userResponse.getUserId())
            .email(userResponse.getEmail())
            .name(userResponse.getName())
            .build();

        CategoryTypeRequest categoryTypeRequest = CategoryTypeRequest.builder()
            .categoryTypeId(categoryTypeResponse.getCategoryTypeId())
            .description(categoryTypeResponse.getDescription())
            .name(categoryTypeResponse.getName())
            .build();

        SubcategoryTypeRequest subcategoryTypeRequest = SubcategoryTypeRequest.builder()
            .subcategoryTypeId(subcategoryTypeResponse.getSubcategoryTypeId())
            .description(subcategoryTypeResponse.getDescription())
            .name(subcategoryTypeResponse.getName())
            .build();


        return transactionUseCase.createTransaction(transactionRequest, userRequest, categoryTypeRequest, subcategoryTypeRequest);
    }

    @Override
    public TransactionResponse update(Long transactionId, TransactionRequest transactionRequest) {

        transactionUseCase.get(transactionId);
        UserResponse userResponse = userUseCase.getUser(transactionRequest.getUserId());
        CategoryTypeResponse categoryTypeResponse = categoryTypeUseCase.getCategoryType(transactionRequest.getCategoryTypeId());
        SubcategoryTypeResponse subcategoryTypeResponse = subcategoryTypeUseCase.getSubCategoryType(transactionRequest.getSubcategoryTypeId());

        UserRequest userRequest = UserRequest.builder()
            .userId(userResponse.getUserId())
            .email(userResponse.getEmail())
            .name(userResponse.getName())
            .build();

        CategoryTypeRequest categoryTypeRequest = CategoryTypeRequest.builder()
            .categoryTypeId(categoryTypeResponse.getCategoryTypeId())
            .description(categoryTypeResponse.getDescription())
            .name(categoryTypeResponse.getName())
            .build();

        SubcategoryTypeRequest subcategoryTypeRequest = SubcategoryTypeRequest.builder()
            .subcategoryTypeId(subcategoryTypeResponse.getSubcategoryTypeId())
            .description(subcategoryTypeResponse.getDescription())
            .name(subcategoryTypeResponse.getName())
            .build();
        return transactionUseCase.updateTranasction(transactionId, transactionRequest, userRequest, categoryTypeRequest, subcategoryTypeRequest);

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
