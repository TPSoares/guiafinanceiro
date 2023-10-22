package com.tpsoares.guiafinanceiro.repository;

import com.tpsoares.guiafinanceiro.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    TODO: Get all transactions by user

    Optional<Transaction> findByTransactionIdAndEnabled(Long id, Boolean enabled);
    List<Transaction> findByEnabledOrderByTransactionDateDesc(Boolean enabled);

    @Query("SELECT t FROM Transaction t WHERE MONTH(t.transactionDate) = MONTH(CURRENT_DATE) AND t.transactionType.transactionTypeId = 2")
    List<Transaction> findTransactionsFromCurrentMonth();
}
