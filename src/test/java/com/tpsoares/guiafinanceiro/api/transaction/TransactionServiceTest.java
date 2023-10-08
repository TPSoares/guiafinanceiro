package com.tpsoares.guiafinanceiro.api.transaction;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import com.tpsoares.guiafinanceiro.repository.TransactionRepository;
import com.tpsoares.guiafinanceiro.usecase.TransactionUseCase;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TransactionUseCase.class})
@ExtendWith(SpringExtension.class)
class TransactionServiceTest {
    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionUseCase transactionService;

    /**
     * Method under test: {@link TransactionUseCase#list()}
     */
//    @Test
    // test that the method returns a Result.success with a list of TransactionOutputDto using transactionTestBuilders to fill the list
//    public void testList() {
//        when(this.transactionRepository.findByEnabledOrderByTransactionDateDesc(Mockito.anyBoolean()))
//                .thenReturn(TransactionTestBuilders.createTransactionListMock());
//        Result<List<TransactionOutputDto>, Exception> actualList = this.transactionService.list();
//        assertNotNull(actualList);
//        assertTrue(actualList instanceof Result.Success<List<TransactionOutputDto>, Exception>);
//        verify(this.transactionRepository).findByEnabledOrderByTransactionDateDesc(Mockito.anyBoolean());
//    }
//
//
//    // test that the method returns a Result.error with a TransactionNotFoundException
//    @Test
//    public void testList2() {
//        when(this.transactionRepository.findByEnabledOrderByTransactionDateDesc(Mockito.anyBoolean())).thenReturn(null);
//        Result<List<TransactionOutputDto>, Exception> actualList = this.transactionService.list();
//        assertNotNull(actualList);
//        assertTrue(actualList instanceof Result.Error<List<TransactionOutputDto>, Exception>);
//        verify(this.transactionRepository).findByEnabledOrderByTransactionDateDesc(Mockito.anyBoolean());
//    }
}

