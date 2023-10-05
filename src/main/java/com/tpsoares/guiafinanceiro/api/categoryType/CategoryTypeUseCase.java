package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeDto;
import com.tpsoares.guiafinanceiro.api.exceptions.CategoryTypeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryTypeUseCase {

    CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeUseCase(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public CategoryTypeDto getCategoryType(Long categoryTypeId) {
        return categoryTypeRepository.findById(categoryTypeId)
            .map(CategoryTypeMapper::toDomain)
            .orElseThrow(CategoryTypeNotFoundException::new);
    }
//
//    public Result<List<CategoryTypeOutputDto>, Exception> list() {
//
//        try {
//            return Result.success(CategoryTypeMapper.toCategoryTypeList(categoryTypeRepository.findAll()));
//        } catch (Exception e) {
//            return Result.error(e);
//        }
//    }
}
