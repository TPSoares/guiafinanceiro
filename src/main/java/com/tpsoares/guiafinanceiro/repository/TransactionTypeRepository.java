package com.tpsoares.guiafinanceiro.repository;

import com.tpsoares.guiafinanceiro.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {

}
