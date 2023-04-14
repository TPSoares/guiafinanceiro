package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryTypeService;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryTypeService;
import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionInputDto;
import com.tpsoares.guiafinanceiro.api.user.UserService;
import com.tpsoares.guiafinanceiro.utils.ServiceResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;
    private final CategoryTypeService categoryTypeService;
    private final SubcategoryTypeService subcategoryTypeService;
    private final ServiceResponseUtils serviceResponseUtils;

    public TransactionController(TransactionService transactionService, UserService userService, CategoryTypeService categoryTypeService, SubcategoryTypeService subcategoryTypeService, ServiceResponseUtils serviceResponseUtils) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.categoryTypeService = categoryTypeService;
        this.subcategoryTypeService = subcategoryTypeService;
        this.serviceResponseUtils = serviceResponseUtils;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        return transactionService.list()
                .map(transactionOutputDtos -> serviceResponseUtils.responseEntitySuccess(transactionOutputDtos, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Object> get(@PathVariable Long transactionId) {
        return transactionService.get(transactionId)
                .map(transactionOutputDto -> serviceResponseUtils.responseEntitySuccess(transactionOutputDto, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody TransactionInputDto transactionInputDto) {
        return transactionService.checkInputDtoAndReturnBuilder(transactionInputDto)
                .flatMap(transactionBuilder -> userService.getUser(transactionBuilder, transactionInputDto))
                .flatMap(transactionBuilder -> categoryTypeService.getCategoryType(transactionBuilder, transactionInputDto))
                .flatMap(transactionBuilder -> subcategoryTypeService.getSubCategoryType(transactionBuilder, transactionInputDto))
                .flatMap(transactionService::saveTransaction)
                .map(transactionOutputDto -> serviceResponseUtils.responseEntitySuccess(transactionOutputDto, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Object> update(@PathVariable Long transactionId, @RequestBody TransactionInputDto transactionInputDto) {
        return transactionService.checkInputDtoAndReturnBuilder(transactionInputDto)
                .flatMap(transactionBuilder -> transactionService.getTransaction(transactionBuilder, transactionId))
                .flatMap(transactionBuilder -> userService.getUser(transactionBuilder, transactionInputDto))
                .flatMap(transactionBuilder -> categoryTypeService.getCategoryType(transactionBuilder, transactionInputDto))
                .flatMap(transactionBuilder -> subcategoryTypeService.getSubCategoryType(transactionBuilder, transactionInputDto))
                .flatMap(transactionService::saveTransaction)
                .map(transactionOutputDto -> serviceResponseUtils.responseEntitySuccess(transactionOutputDto, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }

    @GetMapping("/monthly")
    public ResponseEntity<Object> findTransactionTotalByMonth() {
        return transactionService.findTransactionTotalByMonth()
                .map(transactionOutputDto -> serviceResponseUtils.responseEntitySuccess(transactionOutputDto, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }

    @GetMapping("/monthly-by-subcategory")
    public ResponseEntity<Object> findTransactionMonthlyBySubCategory() {
        return transactionService.findTransactionMonthlyBySubCategory()
                .map(transactionOutputDto -> serviceResponseUtils.responseEntitySuccess(transactionOutputDto, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }
}
