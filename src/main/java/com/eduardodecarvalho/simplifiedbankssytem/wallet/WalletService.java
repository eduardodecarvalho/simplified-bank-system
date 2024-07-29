package com.eduardodecarvalho.simplifiedbankssytem.wallet;

import java.util.List;

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

    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

}
