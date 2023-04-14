package com.tpsoares.guiafinanceiro.api.subcategoryType;

import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import com.tpsoares.guiafinanceiro.api.exceptions.SubcategoryTypeNotFoundException;
import com.tpsoares.guiafinanceiro.api.transaction.Transaction;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.core.Result;
import com.tpsoares.guiafinanceiro.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoryTypeService {

    private final SubcategoryTypeRepository subcategoryTypeRepository;

    public SubcategoryTypeService(SubcategoryTypeRepository subcategoryTypeRepository) {
        this.subcategoryTypeRepository = subcategoryTypeRepository;
    }

    public Result<Transaction.TransactionBuilder, Exception> getSubCategoryType(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            SubcategoryType subcategoryType = null;

            if (transactionInputDto.getSubcategoryTypeId() != null) {
                Optional<SubcategoryType> subcategoryTypeOptional = subcategoryTypeRepository.findById(transactionInputDto.getSubcategoryTypeId());

                if (subcategoryTypeOptional.isPresent()) {
                    subcategoryType = subcategoryTypeOptional.get();
                } else {
                    return Result.error(new SubcategoryTypeNotFoundException());
                }
            }

            transactionBuilder.subcategoryType(subcategoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(e);
        }
    }
}
