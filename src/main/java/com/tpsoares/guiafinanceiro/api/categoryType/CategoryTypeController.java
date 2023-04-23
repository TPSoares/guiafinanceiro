package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.utils.ServiceResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category-types")
public class CategoryTypeController {
    private final CategoryTypeService categoryTypeService;
    private final ServiceResponseUtils serviceResponseUtils;

    public CategoryTypeController(CategoryTypeService categoryTypeService, ServiceResponseUtils serviceResponseUtils) {
        this.categoryTypeService = categoryTypeService;
        this.serviceResponseUtils = serviceResponseUtils;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        return categoryTypeService.list()
                .map(categoryTypeOutputDtos -> serviceResponseUtils.responseEntitySuccess(categoryTypeOutputDtos, HttpStatus.OK))
                .orElse(serviceResponseUtils::responseEntityError);
    }
}
