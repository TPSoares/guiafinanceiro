package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.gateway.CategoryTypeGateway;
import com.tpsoares.guiafinanceiro.mapper.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.model.CategoryType;
import com.tpsoares.guiafinanceiro.repository.CategoryTypeRepository;
import com.tpsoares.guiafinanceiro.exceptions.CategoryTypeNotFoundException;
import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryTypeUseCase {

    private final CategoryTypeGateway categoryTypeRepository;

    public CategoryTypeUseCase(CategoryTypeGateway categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public List<CategoryTypeDto> list() {
        return categoryTypeRepository.findAll();
    }

    public CategoryTypeDto getCategoryType(Long categoryTypeId) {
        return categoryTypeRepository.findById(categoryTypeId)
            .orElseThrow(CategoryTypeNotFoundException::new);
    }
}
