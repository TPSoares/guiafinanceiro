package com.tpsoares.guiafinanceiro.api.controller;

import com.tpsoares.guiafinanceiro.api.dto.SubcategoryTypeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/subcategory-types")
public interface SubcategoryController {

    @GetMapping
    List<SubcategoryTypeDto> list();
}
