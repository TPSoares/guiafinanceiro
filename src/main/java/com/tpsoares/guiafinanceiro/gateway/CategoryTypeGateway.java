package com.tpsoares.guiafinanceiro.gateway;

import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;

import java.util.List;
import java.util.Optional;

public interface CategoryTypeGateway {

    Optional<CategoryTypeDto> findById(Long categoryTypeId);

    List<CategoryTypeDto> findAll();
}
