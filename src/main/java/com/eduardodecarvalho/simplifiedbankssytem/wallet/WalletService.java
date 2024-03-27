package com.eduardodecarvalho.simplifiedbankssytem.wallet;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet findById(Long id) throws NotFoundException {
        return walletRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }

}
