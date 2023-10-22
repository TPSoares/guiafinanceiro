package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.mapper.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.repository.CategoryTypeRepository;
import com.tpsoares.guiafinanceiro.exceptions.CategoryTypeNotFoundException;
import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryTypeUseCase {

    private final CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeUseCase(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public CategoryTypeDto getCategoryType(Long categoryTypeId) {
        return categoryTypeRepository.findById(categoryTypeId)
            .map(CategoryTypeMapper::toDomain)
            .orElseThrow(CategoryTypeNotFoundException::new);
    }
}
