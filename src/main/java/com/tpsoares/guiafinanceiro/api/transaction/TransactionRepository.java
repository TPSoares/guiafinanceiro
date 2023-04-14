package com.tpsoares.guiafinanceiro.api.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    TODO: Get all transactions by user

    Transaction findByTransactionIdAndEnabled(Long id, Boolean enabled);
    List<Transaction> findByEnabled(Boolean enabled);

    @Query(
        value = "SELECT " +
                "SUM(CASE WHEN tt.category_type_id = 2 THEN transaction_value ELSE 0 END) AS monthly_expense, " +
                "SUM(CASE WHEN tt.category_type_id = 1 THEN transaction_value ELSE 0 END) AS monthly_income, " +
                "MONTH(transaction_date) as month_date  " +
                "FROM t_transaction tt  " +
                "WHERE tt.transaction_date  > (DATE_SUB(CURDATE(), INTERVAL 12 MONTH)) " +
                "GROUP BY MONTH(transaction_date) " +
                "ORDER BY MONTH(transaction_date)",
        nativeQuery = true
    )
    List<Object[]> findTransactionTotalByMonth();

    @Query(
            value = "SELECT " +
                    "SUM(transaction_value) AS monthly_expense, " +
                    "tst.description " +
                    "FROM t_transaction tt  " +
                    "LEFT JOIN t_subcategory_type tst ON tt.subcategory_type_id = tst.subcategory_type_id " +
                    "WHERE tt.transaction_date  > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) " +
                    "GROUP BY tst.description",
            nativeQuery = true
    )
    List<Object[]> findMonthlyExpensesBySubCategoryType();
}