package com.tpsoares.guiafinanceiro.api.categoryType;

public class CategoryTypeService {

    CategoryTypeRepository categoryTypeRepository;

    public CategoryTypeService(CategoryTypeRepository categoryTypeRepository) {
        this.categoryTypeRepository = categoryTypeRepository;
    }

}
