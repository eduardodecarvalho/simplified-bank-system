package com.eduardodecarvalho.simplifiedbankssytem.wallet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping()
    public Wallet create(@RequestBody Wallet entity) {
        return walletService.save(entity);
    }

    @GetMapping()
    public List<Wallet> findAll() {
        return walletService.findAll();
    }

}
