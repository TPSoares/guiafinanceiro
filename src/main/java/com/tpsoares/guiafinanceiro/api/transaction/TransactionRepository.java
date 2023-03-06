package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.transaction.dto.TransactionByMonthDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByTransactionIdAndEnabled(Long id, Boolean enabled);
    List<Transaction> findByEnabled(Boolean enabled);

    @Query(
        value = "SELECT " +
            "SUM(CASE WHEN tt.category_type_id = 2 THEN transaction_value ELSE 0 END) AS monthly_expense, " +
            "SUM(CASE WHEN tt.category_type_id = 1 THEN transaction_value ELSE 0 END) AS monthly_income, " +
            "MONTH(transaction_date) as month_date " +
        "FROM t_transaction tt " +
        "WHERE tt.transaction_date  > (DATE_SUB(CURDATE(), INTERVAL 12 MONTH)) " +
        "GROUP BY YEAR(tt.transaction_date), MONTH(transaction_date) " +
        "ORDER BY YEAR(tt.transaction_date), MONTH(transaction_date)",
        nativeQuery = true
    )
    List<Object[]> findTransactionTotalByMonth();
}