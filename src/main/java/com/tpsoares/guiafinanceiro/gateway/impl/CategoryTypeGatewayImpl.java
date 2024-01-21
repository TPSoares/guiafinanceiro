package com.tpsoares.guiafinanceiro.gateway.impl;

import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import com.tpsoares.guiafinanceiro.gateway.CategoryTypeGateway;
import com.tpsoares.guiafinanceiro.mapper.CategoryTypeMapper;
import com.tpsoares.guiafinanceiro.repository.CategoryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryTypeGatewayImpl implements CategoryTypeGateway {

    private final CategoryTypeRepository categoryTypeRepository;

    @Override
    public Optional<CategoryTypeDto> findById(Long categoryTypeId) {
        return categoryTypeRepository.findById(categoryTypeId)
            .map(CategoryTypeMapper::toDomain);
    }

    @Override
    public List<CategoryTypeDto> findAll() {
        return categoryTypeRepository.findAll()
            .stream()
            .map(CategoryTypeMapper::toDomain)
            .toList();
    }
}
