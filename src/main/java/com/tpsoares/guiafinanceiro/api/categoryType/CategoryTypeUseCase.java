package com.tpsoares.guiafinanceiro.api.categoryType;

import com.tpsoares.guiafinanceiro.api.categoryType.dto.CategoryTypeResponse;
import com.tpsoares.guiafinanceiro.api.exceptions.CategoryTypeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryTypeUseCase {

    CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeUseCase(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public CategoryTypeResponse getCategoryType(Long categoryTypeId) {
        return CategoryTypeMapper.toDomain(categoryTypeRepository.findById(categoryTypeId)
            .orElseThrow(CategoryTypeNotFoundException::new));
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
