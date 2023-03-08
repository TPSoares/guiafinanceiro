package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeRepository;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
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
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }

    public Result<TransactionOutputDto, ResponseError> update(Long transactionId, TransactionInputDto transactionInputDto) {

        try {

            Transaction transaction = TransactionMapper.toEntity(transactionId, transactionInputDto);

            transactionRepository.save(transaction);

            TransactionOutputDto transactionOutputDto = TransactionMapper.toOutputDto(transaction);
            return Result.success(transactionOutputDto);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }

    private Result<TransactionOutputDto, ResponseError> saveTransaction(Transaction.TransactionBuilder transactionBuilder) {

        try {
            return Result.success(TransactionMapper.toOutputDto(transactionRepository.save(transactionBuilder.build())));
        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }

    private Result<Transaction.TransactionBuilder, ResponseError> checkInputDtoAndReturnBuilder(TransactionInputDto transactionInputDto) {

        if (transactionInputDto == null) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }

        return Result.success(TransactionMapper.inputMap(transactionInputDto));
    }

    private Result<Transaction.TransactionBuilder, ResponseError> getUser(Transaction.TransactionBuilder transactionBuilder, TransactionInputDto transactionInputDto) {
        try {
            User user = null;

            if (transactionInputDto.getUserId() != null) {
                Optional<User> userOptional = userRepository.findById(transactionInputDto.getUserId());

                if (userOptional.isPresent()) {
                    user = userOptional.get();
                }
            }

            transactionBuilder.user(user);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
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
                }
            }

            transactionBuilder.categoryType(categoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
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
                }
            }

            transactionBuilder.subcategoryType(subcategoryType);

            return Result.success(transactionBuilder);

        } catch (Exception e) {
            return Result.error(ResponseError.builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code("500000")
                    .errorMessage("Internal server error.")
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
                    .code("500000")
                    .errorMessage("Internal server error.")
                    .build());
        }
    }
}
