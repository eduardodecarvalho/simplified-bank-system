package com.eduardodecarvalho.simplifiedbankssytem.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardodecarvalho.simplifiedbankssytem.notification.NotificationService;
import com.eduardodecarvalho.simplifiedbankssytem.wallet.WalletRepository;
import com.eduardodecarvalho.simplifiedbankssytem.wallet.WalletType;

import kafka.admin.AclCommand.AuthorizerService;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private WalletRepository walletRepository;

    @Mock
    private AuthorizerService authorizerService;

    @Mock
    private NotificationService notificationService;

    @Test
    public void testCreateTransactionSuccess() {
        Transaction transaction = new Transaction(null, 1L, 2L, new BigDecimal(1000), null, 1L);
        var payee = new Wallet(transaction.payee(),
                null,
                null,
                null,
                null,
                0,
                BigDecimal.ZERO, 1L);
        var payer = new Wallet(transaction.payer(), null, null, null, null, WalletType.INDIVIDUAL.getValue(),
                new BigDecimal(1000), 1L);

        var byId = walletRepository.findById(transaction.payee());
        when(byId).thenReturn(payee);
        when(walletRepository.findById(transaction.payer())).thenReturn(Optional.of(payer));
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        var newTransaction = transactionService.create(transaction);

        assertEquals(transaction, newTransaction);
    }

    @ParameterizedTest
    @MethodSource("providesInvalidTransactions")
    public void testCreateInvalidTransaction(Transaction transaction) {
        assertThrows(InvalidTransactionException.class,
                () -> transactionService.create(transaction));
    }

    private static Stream<Arguments> providesInvalidTransactions() {
        var transactionLojista = new Transaction(null, 2L, 1L, new BigDecimal(1000), null);
        var transactionInsuficientBalance = new Transaction(null, 1L, 2L, new BigDecimal(1001), null);
        var transactionPayerEqualsPayee = new Transaction(null, 1L, 1L, new BigDecimal(1000), null);
        var transactionUnexistingPayee = new Transaction(null, 1L, 11L, new BigDecimal(1000), null);
        var transactionUnexistingPayer = new Transaction(null, 11L, 1L, new BigDecimal(1000), null);

        return Stream.of(
                Arguments.of(transactionLojista),
                Arguments.of(transactionInsuficientBalance),
                Arguments.of(transactionPayerEqualsPayee),
                Arguments.of(transactionUnexistingPayee),
                Arguments.of(transactionUnexistingPayer));
    }

}
