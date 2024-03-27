package com.eduardodecarvalho.simplifiedbankssytem.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> list() {
        return transactionService.findAll();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) throws Exception {
        return transactionService.create(transaction);
    }

}
