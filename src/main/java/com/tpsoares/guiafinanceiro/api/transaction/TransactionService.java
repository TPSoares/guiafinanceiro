package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.enums.ErrorCodes;
import com.tpsoares.guiafinanceiro.api.enums.ErrorMessages;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionMonthlyBySubCategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionOutputDto;
import com.tpsoares.guiafinanceiro.api.user.User;
import com.tpsoares.guiafinanceiro.api.user.UserRepository;
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
    private final UserRepository userRepository;
    private final CategoryTypeRepository categoryTypeRepository;
    private final SubcategoryTypeRepository subcategoryTypeRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, CategoryTypeRepository categoryTypeRepository, SubcategoryTypeRepository subcategoryTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryTypeRepository = categoryTypeRepository;
        this.subcategoryTypeRepository = subcategoryTypeRepository;
    }

    public Result<List<TransactionOutputDto>, ResponseError> list() {

        try {
            List<Transaction> transactionList = transactionRepository.findByEnabled(TRANSACTION_ENABLED);

            List<TransactionOutputDto> transactionOutputDtoList = TransactionMapper.toOutputDtoList(transactionList);

            return Result.success(transactionOutputDtoList);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
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
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
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
                        .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                        .code(ErrorCodes.TRANSACTION_NOT_FOUND.getValue())
                        .errorMessage(ErrorMessages.TRANSACTION_NOT_FOUND.getValue())
                        .build());
            }

            return Result.success(transaction);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    public Result<TransactionOutputDto, ResponseError> create(TransactionInputDto transactionInputDto) {

        try {

            return checkInputDtoAndReturnBuilder(transactionInputDto)
                    .flatMap(transactionBuilder -> getUser(transactionBuilder, transactionInputDto))
                    .flatMap(transactionBuilder -> getCategoryType(transactionBuilder, transactionInputDto))
                    .flatMap(transactionBuilder -> getSubCategoryType(transactionBuilder, transactionInputDto))
                    .flatMap(this::saveTransaction);


        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    public Result<TransactionOutputDto, ResponseError> update(Long transactionId, TransactionInputDto transactionInputDto) {

        try {

            return checkInputDtoAndReturnBuilder(transactionInputDto)
                    .flatMap(transactionBuilder -> getTransaction(transactionBuilder, transactionId))
                    .flatMap(transactionBuilder -> getUser(transactionBuilder, transactionInputDto))
                    .flatMap(transactionBuilder -> getCategoryType(transactionBuilder, transactionInputDto))
                    .flatMap(transactionBuilder -> getSubCategoryType(transactionBuilder, transactionInputDto))
                    .flatMap(this::saveTransaction);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    private Result<TransactionOutputDto, ResponseError> saveTransaction(Transaction.TransactionBuilder transactionBuilder) {

        try {
            return Result.success(TransactionMapper.toOutputDto(transactionRepository.save(transactionBuilder.build())));
        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    private Result<Transaction.TransactionBuilder, ResponseError> checkInputDtoAndReturnBuilder(TransactionInputDto transactionInputDto) {

        if (transactionInputDto == null) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .code(ErrorCodes.INVALID_FIELD.getValue())
                    .errorMessage(ErrorMessages.INVALID_FIELD.getValue())
                    .build());
        }

        return Result.success(TransactionMapper.inputMap(transactionInputDto));
    }

    private Result<Transaction.TransactionBuilder, ResponseError> getTransaction(Transaction.TransactionBuilder transactionBuilder, Long transactionId) {
        try {

            if (transactionId != null) {
                Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);

                if (transactionOptional.isEmpty()) {
                    return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                            .code(ErrorCodes.TRANSACTION_NOT_FOUND.getValue())
                            .errorMessage(ErrorMessages.TRANSACTION_NOT_FOUND.getValue())
                            .build());
                }
            }

            transactionBuilder.transactionId(transactionId);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    private Result<Transaction.TransactionBuilder, ResponseError> getUser(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            User user = null;

            if (transactionInputDto.getUserId() != null) {
                Optional<User> userOptional = userRepository.findById(transactionInputDto.getUserId());

                if (userOptional.isPresent()) {
                    user = userOptional.get();
                } else {
                    return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                            .code(ErrorCodes.USER_NOT_FOUND.getValue())
                            .errorMessage(ErrorMessages.USER_NOT_FOUND.getValue())
                            .build());
                }
            }

            transactionBuilder.user(user);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    private Result<Transaction.TransactionBuilder, ResponseError> getCategoryType(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            CategoryType categoryType = null;

            if (transactionInputDto.getCategoryTypeId() != null) {
                Optional<CategoryType> categoryTypeOptional = categoryTypeRepository.findById(transactionInputDto.getCategoryTypeId());

                if (categoryTypeOptional.isPresent()) {
                    categoryType = categoryTypeOptional.get();
                } else {
                    return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                            .code(ErrorCodes.CATEGORY_TYPE_NOT_FOUND.getValue())
                            .errorMessage(ErrorMessages.CATEGORY_TYPE_NOT_FOUND.getValue())
                            .build());
                }
            }

            transactionBuilder.categoryType(categoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }

    private Result<Transaction.TransactionBuilder, ResponseError> getSubCategoryType(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            SubcategoryType subcategoryType = null;

            if (transactionInputDto.getSubcategoryTypeId() != null) {
                Optional<SubcategoryType> subcategoryTypeOptional = subcategoryTypeRepository.findById(transactionInputDto.getSubcategoryTypeId());

                if (subcategoryTypeOptional.isPresent()) {
                    subcategoryType = subcategoryTypeOptional.get();
                } else {
                    return Result.error(ResponseError.builder()
                            .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                            .code(ErrorCodes.SUBCATEGORY_TYPE_NOT_FOUND.getValue())
                            .errorMessage(ErrorMessages.SUBCATEGORY_TYPE_NOT_FOUND.getValue())
                            .build());
                }
            }

            transactionBuilder.subcategoryType(subcategoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
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

    public Result<List<TransactionMonthlyBySubCategoryTypeDto>, ResponseError> findTransactionMonthlyBySubCategory() {
        try {

            List<Object[]> result = transactionRepository.findMonthlyExpensesBySubCategoryType();

            List<TransactionMonthlyBySubCategoryTypeDto> transactionMonthlyBySubCategoryTypeDtoList = TransactionMapper.toTransactionMonthlyBySubCategoryTypeDto(result);

            return Result.success(transactionMonthlyBySubCategoryTypeDtoList);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorCodes.INTERNAL_SERVER_ERROR.getValue())
                    .errorMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getValue())
                    .build());
        }
    }
}
