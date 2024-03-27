package com.eduardodecarvalho.simplifiedbankssytem.wallet;

public enum WalletType {
    INDIVIDUAL(0), LEGAL_ENTITY(1);

    private int value;

    private WalletType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
