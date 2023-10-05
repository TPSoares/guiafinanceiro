package com.tpsoares.guiafinanceiro.api.transaction;

import com.tpsoares.guiafinanceiro.api.categoryType.CategoryType;
import com.tpsoares.guiafinanceiro.api.subcategoryType.SubcategoryType;
import com.tpsoares.guiafinanceiro.api.user.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TransactionTestBuilders {

    //create transaction mocks from TransactionModel with fake values for tests
    public static Transaction createTransactionMock() {
        return Transaction.builder()
                .transactionId(1L)
                .subcategoryType(SubcategoryType.builder()
                        .subcategoryTypeId(1L)
                        .name("subcategoryTypeName")
                        .build())
                .build();
    }

    //create a list of transactions with all fields from TransactionModel with fake values for tests
    public static List<Transaction> createTransactionListMock() {
        return Arrays.asList(
                Transaction.builder()
                    .transactionId(1L)
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .name("transactionName")
                    .user(createUserMock())
                    .categoryType(CategoryType.builder()
                            .categoryTypeId(1L)
                            .name("categoryTypeName")
                            .build())
                    .subcategoryType(SubcategoryType.builder()
                            .subcategoryTypeId(1L)
                            .name("subcategoryTypeName")
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
                    .categoryType(CategoryType.builder()
                        .categoryTypeId(1L)
                        .name("categoryTypeName")
                        .build())
                    .subcategoryType(SubcategoryType.builder()
                        .subcategoryTypeId(1L)
                        .name("subcategoryTypeName")
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
