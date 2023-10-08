package com.tpsoares.guiafinanceiro.repository;

import com.tpsoares.guiafinanceiro.model.SubcategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryTypeRepository extends JpaRepository<SubcategoryType, Long> {
}
