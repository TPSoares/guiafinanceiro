package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.model.TransactionType;
import com.tpsoares.guiafinanceiro.model.CategoryType;
import com.tpsoares.guiafinanceiro.model.Transaction;
import com.tpsoares.guiafinanceiro.model.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TransactionTestBuilders {

    public static Transaction createTransactionMock() {
        return Transaction.builder()
                .transactionId(1L)
                .categoryType(CategoryType.builder()
                        .categoryTypeId(1L)
                        .name("categoryTypeName")
                        .build())
                .build();
    }

    public static List<Transaction> createTransactionListMock() {
        return Arrays.asList(
                Transaction.builder()
                    .transactionId(1L)
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .name("transactionName")
                    .user(createUserMock())
                    .transactionType(TransactionType.builder()
                            .transactionTypeId(1L)
                            .name("categoryTypeName")
                            .build())
                    .categoryType(CategoryType.builder()
                            .categoryTypeId(1L)
                            .name("categoryTypeName")
                            .build())
                    .enabled(true)
                    .transactionDate(new Date())
                    .transactionValue("1.0")
                    .build(),
                Transaction.builder()
                    .transactionId(2L)
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .name("transactionName")
                    .user(createUserMock())
                    .transactionType(TransactionType.builder()
                        .transactionTypeId(1L)
                        .name("categoryTypeName")
                        .build())
                    .categoryType(CategoryType.builder()
                        .categoryTypeId(1L)
                        .name("categoryTypeName")
                        .build())
                    .enabled(true)
                    .transactionDate(new Date())
                    .transactionValue("1.0")
                    .build()
        );
    }

    // create user mock with all fields from UserModel with fake values for tests
    public static User createUserMock() {
        return User.builder()
            .userId(1L)
            .name("userName")
            .email("userEmail")
            .enabled(true)
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();
    }
}
