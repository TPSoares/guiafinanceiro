package com.tpsoares.guiafinanceiro.api.controller.impl;

import com.tpsoares.guiafinanceiro.api.controller.SubcategoryController;
import com.tpsoares.guiafinanceiro.api.dto.SubcategoryTypeDto;
import com.tpsoares.guiafinanceiro.usecase.SubcategoryTypeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubcategoryTypeControllerImpl implements SubcategoryController {

    private final SubcategoryTypeUseCase subcategoryTypeUseCase;

    @Override
    public List<SubcategoryTypeDto> list() {
        return null;
    }
}
