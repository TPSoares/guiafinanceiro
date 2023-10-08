package com.tpsoares.guiafinanceiro.usecase;

import com.tpsoares.guiafinanceiro.mapper.SubcategoryTypeMapper;
import com.tpsoares.guiafinanceiro.repository.SubcategoryTypeRepository;
import com.tpsoares.guiafinanceiro.exceptions.SubcategoryTypeNotFoundException;
import com.tpsoares.guiafinanceiro.api.dto.SubcategoryTypeDto;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryTypeUseCase {

    private final SubcategoryTypeRepository subcategoryTypeRepository;

    public SubcategoryTypeUseCase(SubcategoryTypeRepository subcategoryTypeRepository) {
        this.subcategoryTypeRepository = subcategoryTypeRepository;
    }

    public SubcategoryTypeDto getSubCategoryType(Long subcategoryTypeId) {
        return subcategoryTypeRepository.findById(subcategoryTypeId)
            .map(SubcategoryTypeMapper::toDomain)
            .orElseThrow(SubcategoryTypeNotFoundException::new);
    }
//
//    public Result<List<SubcategoryTypeOutputDto>, Exception> list() {
//        try {
//            return Result.success(SubcategoryTypeMapper.toSubcategoryTypeList(subcategoryTypeRepository.findAll()));
//        } catch (Exception e) {
//            return Result.error(e);
//        }
//    }
}
