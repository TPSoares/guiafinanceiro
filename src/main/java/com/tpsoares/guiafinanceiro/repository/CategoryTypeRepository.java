package com.tpsoares.guiafinanceiro.repository;

import com.tpsoares.guiafinanceiro.model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {

}
