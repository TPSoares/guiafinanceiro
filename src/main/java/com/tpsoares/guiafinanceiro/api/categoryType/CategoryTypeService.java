package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeOutputDto;
import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import com.tpsoares.guiafinanceiro.api.exceptions.CategoryTypeNotFoundException;
import com.tpsoares.guiafinanceiro.api.transaction.Transaction;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryTypeService {

    CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeService(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public Result<Transaction.TransactionBuilder, Exception> getCategoryType(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            CategoryType categoryType = null;

            if (transactionInputDto.getCategoryTypeId() != null) {
                Optional<CategoryType> categoryTypeOptional = categoryTypeRepository.findById(transactionInputDto.getCategoryTypeId());

                if (categoryTypeOptional.isPresent()) {
                    categoryType = categoryTypeOptional.get();
                } else {
                    return Result.error(new CategoryTypeNotFoundException());
                }
            }

            transactionBuilder.categoryType(categoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(e);
        }
    }

    public Result<List<CategoryTypeOutputDto>, Exception> list() {

        try {
            return Result.success(CategoryTypeMapper.toCategoryTypeList(categoryTypeRepository.findAll()));
        } catch (Exception e) {
            return Result.error(e);
        }
    }
}
