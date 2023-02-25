package com.tpsoares.guiafinanceiro.api.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByTransactionIdAndEnabled(Long id, Boolean enabled);
    List<Transaction> findByEnabled(Boolean enabled);
}