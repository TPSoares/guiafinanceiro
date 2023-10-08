package com.tpsoares.guiafinanceiro.api.controller;

import com.tpsoares.guiafinanceiro.api.dto.CategoryTypeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/category-types")
public interface CategoryController {

    @GetMapping
    List<CategoryTypeDto> list();
}
