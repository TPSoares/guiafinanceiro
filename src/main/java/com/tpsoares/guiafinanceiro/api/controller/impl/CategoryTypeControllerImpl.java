package com.tpsoares.guiafinanceiro.api.controller.impl;

import com.tpsoares.guiafinanceiro.api.controller.CategoryController;
import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import com.tpsoares.guiafinanceiro.usecase.CategoryTypeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryTypeControllerImpl implements CategoryController {

    private final CategoryTypeUseCase categoryTypeUseCase;

    @Override
    public List<CategoryTypeDto> list() {
        return null;
    }
}
