package com.tpsoares.guiafinanceiro.api.subcategoryType;

import com.tpsoares.guiafinanceiro.utils.ServiceResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subcategory-types")
public class SubcategoryTypeController {

//    private final SubcategoryTypeService subcategoryTypeService;
//    private final ServiceResponseUtils serviceResponseUtils;
//
//    public SubcategoryTypeController(SubcategoryTypeService subcategoryTypeService, ServiceResponseUtils serviceResponseUtils) {
//        this.subcategoryTypeService = subcategoryTypeService;
//        this.serviceResponseUtils = serviceResponseUtils;
//    }
//
//    @GetMapping
//    public ResponseEntity<Object> list() {
//        return subcategoryTypeService.list()
//                .map(subcategoryTypeOutputDtos -> serviceResponseUtils.responseEntitySuccess(subcategoryTypeOutputDtos, HttpStatus.OK))
//                .orElse(serviceResponseUtils::responseEntityError);
//    }
}
