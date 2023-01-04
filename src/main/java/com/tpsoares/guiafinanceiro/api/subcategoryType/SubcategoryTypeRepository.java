package com.tpsoares.guiafinanceiro.api.subcategoryType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryTypeRepository extends JpaRepository<SubcategoryType, Long> {
}