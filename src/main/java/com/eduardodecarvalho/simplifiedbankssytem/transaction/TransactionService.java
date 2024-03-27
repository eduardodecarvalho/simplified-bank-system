package com.eduardodecarvalho.simplifiedbankssytem.transaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduardodecarvalho.simplifiedbankssytem.authorization.AuthorizationService;
import com.eduardodecarvalho.simplifiedbankssytem.notification.NotificationService;
import com.eduardodecarvalho.simplifiedbankssytem.wallet.Wallet;
import com.eduardodecarvalho.simplifiedbankssytem.wallet.WalletService;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final WalletService walletService;
    private final AuthorizationService authorizerService;
    private final NotificationService notificationService;

    public TransactionService(TransactionRepository transactionRepository, WalletService walletService,
            AuthorizationService authorizerService, NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.walletService = walletService;
        this.authorizerService = authorizerService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction create(Transaction transaction) throws Exception {
        validateTransaction(transaction);

        var walletPayer = walletService.findById(transaction.payer());
        var walletPayee = walletService.findById(transaction.payee());

        var newTransaction = this.save(transaction, walletPayee, walletPayer);

        authorizerService.authorize(transaction);
        notificationService.notify(newTransaction);

        return newTransaction;
    }

    private Transaction save(Transaction transaction, Wallet walletPayee, Wallet walletPayer)
            throws Exception {
        Transaction newTransaction = transactionRepository.save(transaction);

        walletService.save(walletPayee.credit(transaction.value()));
        walletService.save(walletPayer.debit(transaction.value()));

        return newTransaction;
    }

    private void validateTransaction(Transaction transaction) throws InvalidTransactionException {
        if (transaction.payee().equals(transaction.payer())) {
            throw new InvalidTransactionException("Payee and payer cannot be the same.");
        }
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
