package com.eduardodecarvalho.simplifiedbankssytem.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import com.eduardodecarvalho.simplifiedbankssytem.transaction.InvalidTransactionException;

public record Wallet(
        @Id Long id,
        String fullName,
        String nationalRegistry,
        String email,
        String password,
        int type,
        BigDecimal balance,
        @Version Long version) {

    public Wallet debit(BigDecimal value) throws InvalidTransactionException {
        if (this.balance.compareTo(value) < 0)
            throw new InvalidTransactionException("Balance not valid.");

        if (this.type != WalletType.INDIVIDUAL.getValue())
            throw new InvalidTransactionException("Only individual clients can do debit.");

        return new Wallet(id, fullName, nationalRegistry, email, password, type,
                balance.subtract(value), version);
    }

    public Wallet credit(BigDecimal value) {
        return new Wallet(id, fullName, nationalRegistry, email, password, type, balance.add(value), version);
    }
}
