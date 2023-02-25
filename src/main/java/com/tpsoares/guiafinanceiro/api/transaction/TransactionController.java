package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.utils.ServiceResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final ServiceResponseUtils serviceResponseUtils;

    public TransactionController(TransactionService transactionService, ServiceResponseUtils serviceResponseUtils) {
        this.transactionService = transactionService;
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
}
